/*
Ebba Þóra Hvannberg ebba@hi.is
 */
package is.hi.leikur.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * Dæmi sem sýnir tvo controllera. Þessi klasi inniheldur einn hnapp og
 * tengingu yfir í controller fyrir teninginn. Borð í spili gæti innihaldið
 * borð og tening í öðrum klasa.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class BordController  {

    // Hér þarf að bæta við @FXML og passa að hún sé alltaf.
    @FXML
    private TeningurController teningurController;
    @FXML
    private Button fjoldiReita; // Fjölda reita sem á að fara áfram


    public void initialize() {
        teningurController.setBordController(this);
    }

    /**
     * Sýnir hvernig hægt er að kalla á teningscontrollerinn og þannig fara
     * í báðar áttir á milli tveggja controllera
     * @param event
     */
    @FXML
    private void fyrstiHnappur(ActionEvent event) {
        teningurController.prenta();
    }

    /**
     * Fáum boð frá teningnum um hvað á að fara marga reiti áfram
     * Birtir fjölda reita og gerir teninginn óvirkan
     * @param i fjöldi reita
     */
    void afram(int i) {
        fjoldiReita.setText(""+i);
        teningurController.geraOvirkan();
    }

}
