/**
 * Sýnidæmi fyrir KeyEvents - controller
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */

package is.keyeventorvatakkar.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label fxStefna;     // sýnir stefnuna

    public void setStefna(int upp) {
        fxStefna.setText(upp+"");
    }
}
