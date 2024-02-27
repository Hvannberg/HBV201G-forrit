package is.vidmot;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KeyFramesApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("keyframe-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KeyFrameDaemi");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
