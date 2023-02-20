package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ******************************************************************************
*  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : MargarScene - sýnir hvernig búnir eru til tveir gluggar með sitthvorri senunni
 *
 *
 *  *****************************************************************************
 */
 public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = loader1.load();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root2 = loader2.load();
        nyrGluggi(primaryStage, root1, "Einn gluggi");

        Stage secondaryStage = new Stage();
        secondaryStage.setX(primaryStage.getX()+30);
        secondaryStage.setY(primaryStage.getY()+30);
        nyrGluggi(secondaryStage, root2, "Annar gluggi");
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
