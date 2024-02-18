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
 * Sýnidæmi hvernig hægt er að búa til controller sem gegnir afmörkuðu
 * hlutverki. Í þessu tilfelli er sérstakur controller fyrir teningin. 
 * Notandi getur ýtt á tening og fengið upp tölu. Tenging er yfir á 
 * spilaborð
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TeningurController  {

    @FXML
    private BordController bordController;  // Tenging yfir á spilaborð
    @FXML
    private Button jTeningsHnappur;         // hnappurinn sem hefur teninginn

    /**
     * Initializes the controller class.
     */

    public void initialize() {
        //
    }    
  
    public void prenta() {
        System.out.println("prenta í TeningurController");
    }

    /**
     * Handler fyrir þegar kasta á tening. Niðurstaða er send til spilaborðsins.
     * @param event 
     */
    @FXML
    private void kastaHandler(ActionEvent event) {
        bordController.afram(5);
    }

    /**
     * Tenging sett á spilaborðið 
     * @param aThis 
     */
    public void setBordController(BordController aThis) {
        bordController = aThis;
    }

    /**
     * Hnappur gerður óvirkur 
     */
    public void geraOvirkan() {
        jTeningsHnappur.setDisable(true);
    }


}
