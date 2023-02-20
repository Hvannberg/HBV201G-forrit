
package vika7.vidmot;

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
    private TextField fxTexti;
    @FXML
    private Label fxValid;


    public void initialize() {
        ContextMenu samhengi = fxTexti.getContextMenu();

        // Birta context menu á textasvið þegar action atburður verður á fxTexti
        fxTexti.setOnAction(e -> samhengi.show(fxTexti, Side.BOTTOM, 0, 0));
    }

    /***
     * Atburðahandler fyrir new valmyndarstakið. Birtir einfaldan
     * dialog 
     * @param event atburður ónotað
     */
    @FXML
    private void newHandler(ActionEvent event) {
        Alert newTextabod = new Alert(Alert.AlertType.INFORMATION);
        newTextabod.setTitle("new");
        newTextabod.setHeaderText("new");
        newTextabod.setContentText("new eitthvað ...");

        newTextabod.showAndWait();
    }

    /***
     * Atburðahandler fyrir close valmyndarstakið. 
     * Hættir í forritinu 
     * @param event atburður ónotað
     */
    @FXML
    private void closeHandler(ActionEvent event) {
        fxValid.setText("Closing");
        Platform.exit();
        System.exit(0);
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
     * @param contextMenuEvent
     */
    public void contextHandler(ContextMenuEvent contextMenuEvent) {
        fxTexti.getContextMenu().show(fxTexti, Side.BOTTOM, 0, 0);
        fxValid.setText("Context handler");
        System.out.println ("context handler");
    }

    public void fxCascadingHandler(ActionEvent actionEvent) {
        fxValid.setText("Cascading");
        System.out.println ("Cascading ");
    }

    public void fxAboutHandler(ActionEvent actionEvent) {
        fxValid.setText("About");
    }
}
