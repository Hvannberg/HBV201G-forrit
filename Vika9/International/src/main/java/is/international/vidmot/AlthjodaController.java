/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.international.vidmot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Dæmi um hvernig hægt er að skipta á milli málsvæða
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class AlthjodaController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;

    private ResourceBundle fastar;


    /***
     * Notum resource bundle fyrir fasta úr aðalforriti
     * @param url
     * @param rb  resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fastar = rb;
    }
    /***
     * Handler fyrir hnapp sem birtir mismunandi texta
     * eftir málsvæði
     * @param event
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText(fastar.getString("hallo"));
    }
    /***
     * Skiptum yfir á íslensku. Rótin á trénu verður íslensk
     * @param event
     */
    @FXML
    private void handleIs(ActionEvent event) {
        label.setText("");
        button.getScene().setRoot(AlthjodaMain.rootIsl);
    }

    /***
     * Skiptum yfir á ensku. Rótin á trénu verður íslensk
     * @param event
     */
    @FXML
    private void handleEn(ActionEvent event) {
        label.setText("");
        button.getScene().setRoot(AlthjodaMain.rootEnskt);
    }

}
