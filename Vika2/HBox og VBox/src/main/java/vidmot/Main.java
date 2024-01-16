package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Application klasinn
 *
 * @author Ebba Þóra Hvannberg
 */
public class Main extends Application {
    /**
     * Les inn notendaviðmótslýsingu og birtir aðalgluggann
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("HBox og VBox");
        primaryStage.setScene(new Scene(root, 600, 150));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
