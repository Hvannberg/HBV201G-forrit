package is.vidmot;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *  * Dæmi sem er tekið upprunalega frá JavaCodeJunkie
 *  * en breytt þannig að .fxml skrá er notuð
 *
 *  Aðalklasinn
 */

public class TableViewDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new MainView();
	}
}
