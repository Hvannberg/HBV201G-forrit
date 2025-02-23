
package vidmot;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;

/**
 * Dæmi sem sýnir valmyndir
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class ValmyndirController{

    @FXML
    private TextField fxTexti; // textasvið í glugganum
    @FXML
    private Label fxValid; // sýnir hvað er valið

    /**
     * Upphafsstillir controllerinn
     */
    public void initialize() {
        ContextMenu samhengi = fxTexti.getContextMenu();

        // Birta context menu á textasvið þegar action atburður verður á fxTexti
        // Lambda fall sem tekur inn atburð e og sýnir context menu miðað við fxTexti viðmótshlutnum
        fxTexti.setOnAction(e -> samhengi.show(fxTexti, Side.BOTTOM, 0, 0));
    }

    /***
     * Atburðahandler fyrir close valmyndarstakið. 
     * Hættir í forritinu 
     * @param event atburður ónotað
     */
    @FXML
    private void closeHandler(ActionEvent event) {
        fxValid.setText("Closing");
        Platform.exit();    // losar alla resourca og hættir
    }

    /**
     * Dummy handler fyrir translate aðgerðina í context menu
     * @param actionEvent ónotað
     */
    public void translateHandler(ActionEvent actionEvent) {
        fxValid.setText("Translate handler");
    }

    /**
     * Opnar contextmenu sem er tengdur við textasviðið þegar hægri smellt er í Anchor
     * pane
     * @param contextMenuEvent ónotað
     */
    public void contextHandler(ContextMenuEvent contextMenuEvent) {
        fxTexti.getContextMenu().show(fxTexti, Side.BOTTOM, 0, 0);
        fxValid.setText("Context handler");
    }

    /**
     * Handler fyrir cascading valmyndarstak
     * @param actionEvent ónotað
     */
    public void fxCascadingHandler(ActionEvent actionEvent) {
        fxValid.setText("Cascading");
    }

    /**
     * Handler fyrir about valmyndarstak
     * @param actionEvent ónotað
     */
    public void fxAboutHandler(ActionEvent actionEvent) {
        fxValid.setText("About");
    }

    /**
     * handler fyrir new valmyndarstakið. Opnar Alert glugga
     * @param actionEvent ónotað
     */
    public void newHandler(ActionEvent actionEvent) {
        Alert a = new Alert (Alert.AlertType.INFORMATION,
                "einhver skilaboð", ButtonType.OK);
        a.setTitle("New");
        a.setHeaderText("Hausinn");
        a.showAndWait();
    }
}
