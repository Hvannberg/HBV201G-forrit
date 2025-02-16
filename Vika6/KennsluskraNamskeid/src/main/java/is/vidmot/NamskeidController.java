
package is.vidmot;

import javafx.scene.Scene;
import javafx.stage.Stage;
import is.vinnsla.Namskeid;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class fyrir glugga controller til
 * að sýna námskeið 
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class NamskeidController  {
    // viðmótshlutir
    @FXML
    private Label jKodi;
    @FXML
    private Label jNamskeidTitill;

    private Scene sena;
    /**
     * Frumstillir controllerinn
     */
    public void initialize() {
        // Búa til nýja senu með rótinni af viðmótstrénu
 //       sena = new Scene(jPane);
        // eða
        sena = new Scene (jKodi.getParent().getParent().getParent());
    }

    /**
     * Birtir gluggann með námskeiði í
     * @param namskeid námskeiðið
     */
    public void birtaGluggi(Namskeid namskeid) {
        // setja gögn í viðmótshlutina í tilviksbreytunum
        jKodi.setText(namskeid.getNamsleid());
        jNamskeidTitill.setText(namskeid.getHeiti());

        // Búa til glugga
        Stage gluggi = new Stage();
        // tengja senu við glugga - hér er senan geymd en ekki búin til í hvert skipti
        gluggi.setScene(sena);
        // sýna glugga - non-modal
        gluggi.show();
    }
}
