
package is.vidmot;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Sýnidæmi um StringBinding
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class FXMLDocumentController {

    @FXML
    private Label efri;
    @FXML
    private Label nedri;
    @FXML
    private Label summa;

    private int teljari = 10;


    public void initialize() {
        // Látum summa vera háða útreikningunum sem gerast í 
        // summaBinding hlutnum

        summa.textProperty().bind(Bindings.createStringBinding(() ->
                        String.valueOf(Integer.parseInt(efri.getText()) // hverju á að skila
                                + Integer.parseInt(nedri.getText())), efri.textProperty(),   // Hvaða breytur á að vakta
                nedri.textProperty()));


        // önnur útfærsla með change listener
        /**
         nedri.textProperty().addListener((observable, oldValue, newValue) ->
         {
         summa.setText(String.valueOf(Integer.parseInt(efri.getText()) +
         Integer.parseInt(nedri.getText())));
         });
         **/

    }

    /**
     * Handler fyrir ýttu hnappinn. Setur teljara í efri svæðið
     * og neðri svæðið margfaldað með 10.
     *
     * @param event
     */
    @FXML
    private void yttuHandler(ActionEvent event) {
        teljari = teljari - 1;
        efri.setText(String.valueOf(teljari));
        nedri.setText(String.valueOf(teljari * 10));
    }

}
