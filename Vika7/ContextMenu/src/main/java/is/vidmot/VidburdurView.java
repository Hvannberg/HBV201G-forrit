package is.vidmot;

import hi.verkefni.vinnsla.Vidburdur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Sýnidæmi fyrir context menu
 *
 *
 *****************************************************************************/
public class VidburdurView extends StackPane {

    Vidburdur v;
    @FXML
    private ContextMenu fxMenu;

    public VidburdurView(Vidburdur v) {
        this.v = v;
        lesaVidburd();
    }

    private void lesaVidburd() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vidburdur-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void fxSynaContextMenu(ContextMenuEvent e) {
        fxMenu.show(this, e.getScreenX(), e.getScreenY());
    }

    public void fxEydaVidburdi(ActionEvent e) {
        MainController controller = (MainController) getScene().getUserData();   // tenging við controller
        // Gætum eytt viðburði og viðburðurView hér en beinum því til controller

        controller.fxEydaVidburdi(this);
        System.out.println("eyða viðburði");

    }
}
