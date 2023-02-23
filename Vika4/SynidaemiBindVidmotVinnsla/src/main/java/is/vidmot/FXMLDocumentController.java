package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vinnsla.Blad;

/**
 * Sýnidæmi fyrir hvernig breyta er bundin (bind) við aðra þannig
 * að þegar breytan breytir um gildi þá breytist háða breytan samkvæmt
 * einhverri formúlu.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class FXMLDocumentController {
    private final Blad mittBlad = new Blad();
    // Viðmótshlutir

    @FXML
    private TextField inntak;
    @FXML
    private Label fxTala;

    public void initialize() {

        // Sýnir hvernig við bindum notendaviðmótshlut (fxTala)
        // við vinnsluhlut - (mittBlad)
        fxTala.textProperty().
                bind(mittBlad.talaProperty().asString());
    }

    public void handleNyTala(ActionEvent actionEvent) {
        // uppfæri vinnsluna
        mittBlad.reikna(Integer.parseInt(inntak.getText()));
    }
}
