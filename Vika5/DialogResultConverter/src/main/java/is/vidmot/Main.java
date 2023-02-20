
package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Aðalforritið
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("adal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sýnidæmi fyrir dialog - resultConverter ");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
