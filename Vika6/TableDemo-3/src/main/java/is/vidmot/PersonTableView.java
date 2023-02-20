package is.vidmot;

import is.vinnsla.Person;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

/**
 * Dæmi sem er tekið upprunalega frá JavaCodeJunkie
 * en breytt þannig að .fxml skrá er notuð
 *
 * Sýnir sérhæfðan klasa
 */
public class PersonTableView extends VBox {
    @FXML
    private TableView<Person> table;    // taflan
    @FXML
    private TableColumn<Person, String> firstNameCol; // dálkarnir koma hér á eftir
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private TableColumn<Person, Integer> ageCol;

    /**
     * Lesa inn viðmótið
     */
    public PersonTableView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("personTable-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setjaGogn();
    }

    /**
     * Setja upp bindingu á milli gagna og viðmóts
     */
    private void setjaGogn() {
        // til að hægt sé að gera breytingar á töflu með því að tvísmella
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(event -> {    // ef breytingar eru gerðar
            Person person = event.getRowValue();
            person.setFirstName(event.getNewValue());
        });


        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setLastName(event.getNewValue());
        });


        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setAge(event.getNewValue());
        });
    }

    /**
     * Bæta við persónum í töfluna
     * @param person
     */
    public void add(Person person) {
        table.getItems().add(person);
    }
}
