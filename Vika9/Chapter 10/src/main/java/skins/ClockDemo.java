package skins;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author sgrinev
 *
 * EÞH - breytingar fólust í að lesa inn notendaviðmót úr .fxml skrá
 */
public class ClockDemo extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        // Hér sést gamli kóðinn sem býr til viðmótið í forritinu

/*        Scene scene = new Scene(new HBox(50,
                new ClockControl(ClockControl.SkinType.HANDS),
                new ClockControl(ClockControl.SkinType.TEXT)
        ), 400, 250);*/
        FXMLLoader fxmlLoader = new FXMLLoader(
                ClockController.class.getResource("clock-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 400, 250);

        stage.setScene(scene);
        stage.setTitle("Klukka, kafli 10 í sgrinev");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
