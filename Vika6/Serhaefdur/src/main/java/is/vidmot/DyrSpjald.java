package is.vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Birtir mynd af dýri - sýnir sérhæfðan klasa
 *
 *
 *****************************************************************************/
public class DyrSpjald extends AnchorPane {

    @FXML
    private ImageView fxDyr;    // tilviksbreyta sett inn handvirkt. engin controller settur
    // í .fxml skrána

    /**
     * Les inn .fxml skrá og setur controllerinn sem þessi hlutur
     */
    public DyrSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dyr-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Breytir myndinni á spjaldinu í img
     *
     * @param mynd nýja myndin
     */
    public void setDyrMynd(Image mynd) {
        fxDyr.setImage(mynd);
    }

    /**
     * Handler fyrir þegar músin fer út af svæðinu. Sett handvirkt inn vegna enginn controller
     * í .fxml skránni
     *
     * @param mouseEvent músaratburður
     */
    public void fxMouseExited(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
        ((DyrSpjald) mouseEvent.getSource()).getStyleClass().removeLast(); // rauður fjarlægður
        ((DyrSpjald) mouseEvent.getSource()).getStyleClass().add("graenn");
    }
}
