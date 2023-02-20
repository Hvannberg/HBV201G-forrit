package is.vidmot;

import is.vinnsla.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 *  * Dæmi sem er tekið upprunalega frá JavaCodeJunkie
 *  * en breytt þannig að .fxml skrá er notuð
 *
 * Aðalglugginn
 *
 */

public class MainView {
	@FXML
	private PersonTableView table;	// taflan með persons
	
	public MainView() {
		buildUI();
	}

	/**
	 * Notendaviðmótið lesið inn úr .fxml skránni
	 */
	private void buildUI() {

		Parent p = lesaFXML();

		Stage stage = new Stage(StageStyle.DECORATED);
		Scene scene = new Scene(p, 500, 300);
		stage.setTitle("TableView Demo");
		stage.setScene(scene);

		hladaGognumToflu();

		stage.show();
		
	}

	/**
	 * Gögn sett í töfluna
	 */
	private void hladaGognumToflu() {
		table.add(new Person("Buggs", "Bunny", 79));
		table.add(new Person("Daffy", "Duck", 83));
		table.add(new Person("Foghorn", "Leghorn", 74));
		table.add(new Person("Elmer", "Fudd", 83));
		table.add(new Person("Tweety", "Bird", 73));
	}

	/**
	 * Notendaviðmótið lesið inn og rótinni skilað
	 * @return rótin í viðmótstrénu
	 */
	private Parent lesaFXML() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
		try {
			fxmlLoader.setController(this);
			return fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

	}

}
