package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Dæmi sem er endurforritað frá youtube.com  @JavaCodeJunkie #44
 *
 */
public class SliderApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SliderApplication.class.getResource("slider-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ChangeListener demo - frá JavaCodeJunkie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}