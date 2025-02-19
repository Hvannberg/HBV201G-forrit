package is.mediademo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * MediaPlayer demo by Liang - chapter 16
 * adapted to .fxml
 */
public class MediaDemoApplication extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MediaDemoApplication.class.getResource("mediademo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 600);
        stage.setTitle("MediaDemo");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is only needed for IDEs with limited
     * JavaFX support. It is not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
