package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
/**
 * Application klasinn
 *
 * @author Ebba Þóra Hvannberg
 */
public class Adal extends Application {

    private static final String TITILL = "Heilsa";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Heilsa.fxml")));
        primaryStage.setTitle(TITILL);
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
