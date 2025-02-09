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
        // viðmótstré hlaðið inn í rót root1 - hér verður til einn controller hlutur
        Parent root1 = loader1.load();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("sample.fxml"));
        // viðmótstré hlaðið inn í rót root2 - hér verður til annar controller hlutur
        Parent root2 = loader2.load();
        // Sena sem hefur viðmótstéð  root1 sett í gluggann primaryStage
        nyrGluggi(primaryStage, root1, "Einn gluggi");

        // Búinn til annar gluggi secondaryStage
        Stage secondaryStage = new Stage();

        // Staðsetning á glugganum sett x+30, y+30 miðað við fyrri gluggann
        secondaryStage.setX(primaryStage.getX()+30);
        secondaryStage.setY(primaryStage.getY()+30);

        //  // Sena sem hefur viðmótstéð  root1 sett í gluggann secondaryStage
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
        // senan búinn til með rót af viðmótstrénu root
        Scene s1 = new Scene(root, 300, 275);
        // senan tengd við gluggann
        s.setScene(s1);
        // glugginn birtur
        s.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
