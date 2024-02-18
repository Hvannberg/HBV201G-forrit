package is.vidmot;

import is.vinnsla.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

/**
 * Dæmi sem er tekið upprunalega frá JavaCodeJunkie
 * en breytt þannig að .fxml skrá er notuð
 * <p>
 * Sýnir sérhæfðan klasa
 */
public class PersonTableView extends VBox {
    @FXML
    private TableView<Person> table;    // taflan
    // 2 parametrar inni í goggunum, sá fyrri er klasinn fyrir línuna og sá seinni er klasinn fyrir dálkinn
    @FXML
    private TableColumn<Person, String> firstNameCol; // dálkarnir koma hér á eftir
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private TableColumn<Person, Integer> ageCol;

    /**
     * Lesa inn viðmótið og setja controllerinn
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
        // til að hægt sé að gera breytingar á cellum í töflu með því að tvísmella
        bindingCell(firstNameCol, "firstName");
        // handler sem er keyrður þegar búið er að editera selluna
        firstNameCol.setOnEditCommit(event -> {
            Person person = event.getRowValue(); // náð í gildi af röðinni (Person)
            person.setFirstName(event.getNewValue()); // nýja gildið er sett í tilviksbreytuna fyrir firstName
        });

        // alveg eins nema fyrir eftirnafn
        bindingCell(lastNameCol, "lastName");
        lastNameCol.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setLastName(event.getNewValue());
        });

        // alveg eins nema fyrir age (aldurinn)
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(event -> {
            Person person = event.getRowValue();
            person.setAge(event.getNewValue());
        });
    }

    private void bindingCell(TableColumn<Person, String> col, String colString) {
        // tengir gögnin úr vinnsluklasanum (gagnamódelinu) við viðmótið. Það notar colString til að nota réttu get- aðferðina
        col.setCellValueFactory(new PropertyValueFactory< >(colString));
        // setur upp TextField til að hægt sé að editera sellurnar
        col.setCellFactory(TextFieldTableCell.forTableColumn());
    }



/**
 * Bæta við persónum í töfluna
 * @param person
 */
public void add(Person person) {
    table.getItems().add(person);
}
}
