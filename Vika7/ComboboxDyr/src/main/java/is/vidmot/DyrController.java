
package is.vidmot;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author Ebba Þóra Hvannberg, Háskóli Íslands, ebba@hi.is
 * <p>
 * Sýnidæmi fyrir ComboBox. Mynd af dýri birtist þegar nafn þess er valið úr Comboboxi.
 * Einnig er sýnt hvernig gögn eru geymd í DefaultComboBoxModel
 */
public class DyrController {

    /**
     * Nöfnin á dýrunum. Notum þau líka fyrir myndirnar.
     * Er final því við breytum ekki fylkinu dyrHeiti
     * Er private því við viljum ekki að aðrir klasar hafi beint aðgang að breytunni
     */
    private static final String[] dyrHeiti = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    @FXML
    private ImageView dyramynd;
    @FXML
    private ComboBox<String> dyr;



    public void initialize() {
        // Frumstilla gögnin fyrir ComboBox
        frumstillaGogn();

    }

    /**
     * Frumstillir gögn fyrir ComboBoxið jDyr
     */
    private void frumstillaGogn() {

        ObservableList<String> dyraNofn =
                FXCollections.observableArrayList(dyrHeiti);

        // tengjum gögnin við viðmótshlutinn þannig að gögnin birtist í notendaviðmótinu
        dyr.setItems(dyraNofn);
    }

    /**
     * Uppfærir mynd á dyramynd
     *
     * @param name nafn á dýrinu
     */
    private void uppfaeraMynd(String name) {
        Image icon = buaTilMynd("myndir/" + name + ".gif");
        if (icon != null)
            dyramynd.setImage(icon);
    }

    /**
     * Býr til Mynd
     *
     * @param path slóðin með myndunum
     * @return skilar myndinni en null ef skráin fannst ekki
     * <p>
     * Þetta er dæmi um aðferð sem má vera static því hún meðhöndlar
     * ekki tilviksbreytur.
     */

    private static Image buaTilMynd(String path) {
        URL imgURL = DyrController.class.getResource(path);
        if (imgURL != null) {
            return new Image(imgURL.toString());
        } else {
            System.err.println("Fann ekki skrána " + path);
            return null;
        }
    }

    /**
     * Atburðarhandler fyrir val á dyr
     *
     * @param evt upplýsingar um atburðinn, m.a. viðmótshluturinn sem bjó til atburðinn
     */
    @FXML
    private void jDyrActionPerformed(ActionEvent evt) {
        // Hvaða dýr er valið
        // Sjáum að það er hægt að biðja ComboBoxið um að skila stakinu
        String dyraNafn = dyr.getSelectionModel().getSelectedItem();

        // Uppfærum mynd með nýju dýri
        uppfaeraMynd(dyraNafn);
    }
}
