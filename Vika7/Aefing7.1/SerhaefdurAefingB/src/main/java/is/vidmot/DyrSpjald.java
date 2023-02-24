package is.vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Birtir mynd af dýri
 *
 *
 *****************************************************************************/
public class DyrSpjald extends AnchorPane {

    @FXML
    private ImageView fxDyr;    // tilviksbreyta sett inn handvirkt. engin controller settur
                                // í .fxml skrána

    public DyrSpjald () {
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
     * @param mynd nýja myndin
     */
    public void setDyrMynd(Image mynd) {
        fxDyr.setImage(mynd);
    }
}
