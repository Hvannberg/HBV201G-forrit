
package vidmot;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.WindowEvent;

/**
 * Dæmi sem sýnir valmyndir
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class ValmyndirController implements Initializable {


    public TextField fxTexti;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ContextMenu samhengi = fxTexti.getContextMenu();

        // Birta context menu á textasvið þegar action atburður verður á fxTexti
        fxTexti.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                samhengi.show(fxTexti, Side.BOTTOM, 0, 0);
            }
        });
    }

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
     * Dummy handler fyrir translate aðgerðina í context menu
     * @param actionEvent
     */
    public void translateHandler(ActionEvent actionEvent) {
        System.out.println("translate handler");
    }

    /**
     * Opnar contextmenu sem er tengdur við textasviðið þegar hægri smellt er í Anchor
     * pane
     * @param contextMenuEvent
     */
    public void contextHandler(ContextMenuEvent contextMenuEvent) {
        fxTexti.getContextMenu().show(fxTexti, Side.BOTTOM, 0, 0);
        System.out.println ("context handler");
    }
}
