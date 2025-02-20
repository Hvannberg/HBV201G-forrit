package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Aðalforrit fyrir kisuforritið. Les inn notendaviðmótið
 *  Sýnir sérhæfða klasa (customized components)
 *
 *
 *****************************************************************************/

public class KisaApplication extends Application {
    /**
     * Ræsir forritið
     * @param stage aðalglugginn
     * @throws IOException ef ekki tekst að lesa inn .fxml skrána
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KisaApplication.class
                .getResource("kisur-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kisumyndir");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aðalforritið sem er keyrt
     * @param args ónotað
     */
    public static void main(String[] args) {
        launch();
    }
}
