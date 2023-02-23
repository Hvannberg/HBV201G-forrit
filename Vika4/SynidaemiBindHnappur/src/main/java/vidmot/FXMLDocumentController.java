package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Sýnidæmi fyrir hvernig breyta er bundin (bind) við aðra þannig
 * að þegar breytan breytir um gildi þá breytist háða breytan samkvæmt
 * einhverri formúlu.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class FXMLDocumentController implements Initializable {

    private int fjoldi=3;

    // Viðmótshlutir
    @FXML
    private Button kastaHnappur;
    @FXML
    private Label fjoldiKasta;
    @FXML
    private Button nyUmferd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sýnir hvernig við gerum hlut (kastaHnappur)
        // óvirkan (disabled) þegar viðmótshlutur(fjoldiKasta)
        // hefur ákveðið gildi, hér 0
       kastaHnappur.disableProperty().
               bind(fjoldiKasta.textProperty().
                       isEqualTo("0"));

        // Sýnir hvernig við gerum hlut (nyUmferd) óvirkan þegar
        // annar viðmótshlutur (kastaHnappur) er virkur
        nyUmferd.disableProperty().
                bind(kastaHnappur.disableProperty().not());
    }


    /***
     * Handler fyrir kasta hnappinn. Lækkar fjölda kasta um einn og
     * birtir fjölda kasta
     * @param event  ónotað
     */
    @FXML
    private void kastaHandler(ActionEvent event) {
        // Fjöldi kasta sem eftir er lækkaður um einn og birtur
        fjoldiKastaSettur(fjoldi -1 );
        }


    /**
     * Fjöldi kasta settur og birtur
     * @param f fjöldi kasta
     */
    private void fjoldiKastaSettur(int f) {
        fjoldi = f;
        fjoldiKasta.setText(String.valueOf(fjoldi));
    }

    /**
     * Handler fyrir ný umferð hnappinn. Fjöldi kasta er settur 3
     * og birtur
     * @param event ónotað
     */
    @FXML
    private void nyUmferdHandler(ActionEvent event) {
           fjoldiKastaSettur(3);
    }
}
