package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Dæmið sýnir notkun ListChangeListener
 */
public class ListiApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ListiApplication.class.getResource("listi-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sýnidæmi ListChangeListener");
        stage.setScene(scene);
        LocalDate now =  LocalDate.now();
        System.out.println (now.plusDays(1).minusDays(1));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}