package com.example.dialogdemo.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Main extends Application {

	private final Button addButton = new Button("Add Person");
	private final ListView<String> listView = new ListView<>();

	/**
	 * les inn aðal notendaviðmótið og birtir í primaryStage
	 * @param primaryStage aðalglugginn
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));

			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dialog Demo");
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main aðferðin sem ræsir forritið
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
