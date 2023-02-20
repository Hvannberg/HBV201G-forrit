/*
 *  Ebba Þóra Hvannberg
 */
package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import is.vinnsla.NafnaBanki;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Sýnir hvernig skipt er um lit á hnappi.
 * Getur heilsað með nafni
 *
 * @author Ebba Þóra Hvannberg
 */
public class HeilsaController {

    // viðmótshlutir
    @FXML
    private Button jLitur;
    @FXML
    private Label jHalloNafn;
    @FXML
    private TextField jNafn;

    // gagnahlutir
    private boolean graenn = true;

    private NafnaBanki banki;


    public void initialize() { // ein aðferð sem við þurfum að forrita
        banki = new NafnaBanki();   // búum til hlut af klasanum NafnaBanki
        jHalloNafn.setText("Ekkert Nafn");
    }

    /**
     * Skiptir um lit á hnappnum þannig að hann verður rauður ef hann er grænn og öfugt
     *
     * @param event atburðurinn sem kemur inn en er ónótaður
     */
    @FXML
    private void skiptaUmLitHandler(ActionEvent event) {
        String nyrLitur;

        if (graenn) {
            nyrLitur = "#ff0000";
        } else {
            nyrLitur = "#008000";
        }
        graenn = !graenn;
        jLitur.setStyle("-fx-background-color: " + nyrLitur);
    }

    /**
     * Hreinsar út kveðjuna í jHalloNafn og í inntakssviðinu jNafn
     *
     * @param event atburðurinn sem varð en er ónotað
     */
    @FXML
    private void hreinsaHandler(ActionEvent event) {
        jHalloNafn.setText("");
        jNafn.setText("");
    }

    /**
     * Birtir kveðju í jHalloNafn með textanum sem er í jNafn
     *
     * @param event atburðurinn sem varð en er ónotað
     */
    @FXML
    private void heilsaHandler(ActionEvent event) {

        String nafn = jNafn.getText();
        if (!banki.geymaNafn(nafn))
            jHalloNafn.setText("Gat ekki bætt við nafni");
        else
            jHalloNafn.setText("Halló " + nafn);
    }


}
