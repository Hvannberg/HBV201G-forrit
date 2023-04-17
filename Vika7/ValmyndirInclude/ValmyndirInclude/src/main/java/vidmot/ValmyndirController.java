
package vidmot;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

/**
 * Dæmi sem sýnir valmyndir
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class ValmyndirController {


    public TextField fxTexti;

    @FXML
    private ContextMenu contextAnchor;  // context valmynd fyrir Anchor


    /***
     * Atburðahandler fyrir new valmyndarstakið. Birtir einfaldan
     * dialog
     * @param event
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
     * @param event
     */
    @FXML
    private void closeHandler(ActionEvent event) {
        System.out.println("close handler");
        Platform.exit();
        System.exit(0);
    }


    /**
     * Dummy handler fyrir translate aðgerðina í context menu fyrir textasviðið
     *
     * @param actionEvent ónotað
     */
    public void translateHandler(ActionEvent actionEvent) {
        System.out.println("translate handler");
    }

    /**
     * Opnar contextmenu sem er tengdur við textasviðið þegar hægri smellt er í á textasviðið
     * pane
     *
     * @param contextMenuEvent ónotað
     */
    public void contextHandler(ContextMenuEvent contextMenuEvent) {
        fxTexti.getContextMenu().show(fxTexti, Side.BOTTOM, 0, 0);
    }

    /**
     * handler fyrir valkost B í  contextmenu fyrir anchro
     * @param actionEvent
     */
    public void bHandler(ActionEvent actionEvent) {
        System.out.println("þú valdir B");
    }

    /**
     * Birta context menu fyrir anchor
     * @param e
     */
    public void opnaContextAnchor(ContextMenuEvent e) {
        contextAnchor.show((Node) e.getSource(), e.getScreenX(), e.getScreenY());
    }
}
