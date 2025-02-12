package com.example.dialogdemo.vidmot;

import com.example.dialogdemo.vinnsla.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;

public class PersonDialog extends Dialog<Person> {
	// viðmóts breytur
	@FXML
	private ButtonType okButton; // ok hnappurinn
	@FXML
	private TextField firstNameField; // fornafn
	@FXML
	private TextField lastNameField; // eftirnafn
	// vinnslu breytur
	private final Person person; // person vinnslan

	/**
	 * Smiður sem tekur inn Person hlut (vinnslan) sem notandi fyllir inn í
	 * @param person safna á upplýsingum um persónuna
	 */
	public PersonDialog(Person person) {
		super();
		this.setTitle("Add Person");
		this.person = person;
		buildUI();
		setPropertyBindings();
		setResultConverter();
	}

	/**
	 * Lesa inn .fxml skrána fyrir dialog-inn
	 * @return skilar rótinni af viðmótstrénu sem er DialogPane
	 */
	private DialogPane lesaDialog() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("personDialog-view.fxml"));
		try {
			// controller er settur sem þessi hlutur
			fxmlLoader.setController(this);
			return fxmlLoader.load();
		}
		catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	/**
	 * byggja notendaviðmótið fyrir dialog-inn
	 */
	private void buildUI() {
		setDialogPane( lesaDialog());
		// fletta upp hnappnum
		Button iLagi = (Button)getDialogPane().lookupButton(okButton);

		iLagi.addEventFilter(ActionEvent.ACTION, (ActionEvent event) -> {
                if (!validateDialog()) {
                    event.consume();
                }
        });
		getDialogPane().expandableContentProperty().set(new Label("This is the expandable ontent area"));
		getDialogPane().setExpanded(true);
	}

	/**
	 * Athuga hvort gögnin eru gild
	 * @return true ef búið er að setja inn nafn og eftirnafn
	 */
	private boolean validateDialog() {
		return (!firstNameField.getText().isEmpty()) && (!lastNameField.getText().isEmpty());
	}

	/**
	 * Setja upp bindingar í báðar áttir á milli vinnslu og notendaviðmóts
	 */
	private void setPropertyBindings() {
		firstNameField.textProperty().bindBidirectional(person.firstNameProperty());
		lastNameField.textProperty().bindBidirectional(person.lastNameProperty());
	}

	/**
	 * setja upp gagnaflutning frá dialog yfir á þann sem opnar dialog-inn
	 */
	private void setResultConverter() {
		Callback<ButtonType, Person> personResultConverter = param -> {
            if (param.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return person;
            }
			else {
                return null;
            }
        };
		setResultConverter(personResultConverter);
	}
}
