package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Klasinn sem keyrir forritið og hleður inn upphafs notendaviðmótinu
 *
 * @author Ebba Þóra Hvannberg
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vidmot.fxml"));
        primaryStage.setTitle("Lögun viðmótshlutar");
        primaryStage.setScene(new Scene(root, 150, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
