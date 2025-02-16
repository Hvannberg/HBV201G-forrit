
package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Dæmi sem sýnir ListView
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class KennsluskraMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Kennsluskra.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *  Aðalforritið
     *  @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
