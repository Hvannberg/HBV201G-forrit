/**
 * Sýnidæmi fyrir Hreyfimynd. Aðalklasinn
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
package is.textirotate.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("Text-view.fxml"));
        primaryStage.setTitle("Rotation dæmi");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
