package is.vidmot;
/**
 * Sýnidæmi - Tvær senur búnar til og birtar til skiptis í sama glugganum.
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = loader1.load();
        nyrGluggi(primaryStage, root1, "Einn gluggi");
        Controller c1 = loader1.getController();

        // Sena mótherjans búinn til
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root2 = loader2.load();
        new Scene (root2, 300, 275);    // ekki notað en þarf að búa til senu
        Controller c2 = loader2.getController();

        // látum controllerana benda á hvorn annan
        stillaController(c1, c2, "Jón");
        stillaController(c2, c1, "Bára");

    }

    /**
     * Controller (c1) bendir á annan controller, setja nafn á leikmanni og birta nafn leikmanns
     * @param c1 controller
     * @param c2 controller mótherja
     * @param s nafn leikmanns
     */
    private void stillaController(Controller c1, Controller c2, String s) {
        c1.setLeikmadur(s);
        c1.birtaNafnLeikmanns();
        c1.setMotherjinn(c2);
    }

    /**
     * Birtir nýja senu sem er í root í glugganum s með titlinum t
     * @param s glugginn
     * @param root senan (viðmótstréð)
     * @param t titill á glugganum
     */
    private void nyrGluggi(Stage s, Parent root, String t) {
        s.setTitle(t);
        Scene s1 = new Scene(root, 300, 275);
        s.setScene(s1);
        s.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
