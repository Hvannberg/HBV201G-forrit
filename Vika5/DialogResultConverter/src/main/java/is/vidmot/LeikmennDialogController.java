package is.vidmot;

import is.vinnsla.Leikmenn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Controller fyrir dialog fyrir nöfn tveggja leikmanna
 *
 *
 *****************************************************************************/
public class LeikmennDialogController extends Dialog<Leikmenn> {

    // viðmótshlutir
    @FXML
    private TextField fxLeikmadur1; // nafn leikmanns 1 - engin controller í .fxml skrá þannig að
    // breytur eru ekki litaðar
    @FXML
    private TextField fxLeikmadur2; // nafn leikmanns 2
    @FXML
    private ButtonType fxILagi;

    /**
     * Notendaviðmótið lesið inn og dialogurinn fær pane
     */
    public LeikmennDialogController() {
        // lesa inn dialogpane og setja þennan hlut sem controller
        setDialogPane(lesaLeikmennDialog());
        // sett regla um hvenær í lagi hnappur er virkur
        iLagiRegla();
        // Búum til hlut af nýjum nafnlausum innri klasa sem útfærir interface
        // Callback fyrir klasana ButtonType og Leikmenn
        // Callback hefur eina aðferð og við endurforritum hana
        setResultConverter(b -> {                                 // b er af taginu ButtonType
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return new Leikmenn(fxLeikmadur1.getText(), fxLeikmadur2.getText());
            }
            else {
                return null;
            }
        });         // endir á d.setResultConverter
    }

    /**
     * Útlitið búið til, .fxml skráin lesinn inn og controller settur
     *
     * @return hlutur af DialogPane
     */
    private DialogPane lesaLeikmennDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leikmenn-view.fxml"));
        try {
            // controller er settur sem þessi hlutur
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Regla búin til um hvenær Í lagi hnappurinn á að vera óvirkur/virkur
     */
    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        // setja reglu um hvenær í lagi hnappur er virkur
        iLagi.disableProperty()
                .bind(fxLeikmadur1.textProperty().isEmpty()
                        .or(fxLeikmadur2.textProperty().isEmpty()));
    }

    /**
     * Birtir dialog d og skilar nöfnum leikmanna úr dialog
     *
     * @return skilar nöfnum leikmanna nema ef hætt við þá skilar hann null
     */
    public Leikmenn getNofnLeikmanna() {
        // Dialog birtur og svarið fengið
        Optional<Leikmenn> utkoma = showAndWait();
        return utkoma.orElse(null);
    }
}
