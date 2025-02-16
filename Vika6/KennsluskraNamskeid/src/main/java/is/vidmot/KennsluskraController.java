
package is.vidmot;

import javafx.fxml.FXMLLoader;
import is.vinnsla.Kennsluskra;
import is.vinnsla.Namskeid;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * Sýnir hvernig notaður er klasinn
 * Námskeið í ListView.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class KennsluskraController {

    // Viðmótshlutir
    @FXML
    private ListView<Namskeid> listiNamskeid;
    // Vinnsluhlutinn með gögnunum
    private Kennsluskra kennsluskra = new Kennsluskra();
    // núverandi valdi index
    private int virkurIndex = 0;
    // Controller fyrir Námskeið
    private NamskeidController namskeidController;

    /**
     * Vinnsluhluti tengdur við notendaviðmótið. Geymir núerandi index sem er valinn
     * í listanum
     */
    public void initialize() {
        listiNamskeid.setItems(kennsluskra.getOllNamskeid()); // tengja listann við viðmótið

        // geyma indexinn sem er valinn
        listiNamskeid.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    System.out.println(newValue);
                    if (newValue.intValue() >= 0) {
                        virkurIndex = newValue.intValue();
                    }
                });
        try {
            namskeidController = hladaGluggi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Smíða notendaviðmótið fyrir dialoginn
     *
     * @return námskeiðs controller
     * @throws IOException ef lesturinn gengur ekki
     */
    private NamskeidController hladaGluggi() throws IOException {
        FXMLLoader dLoader = new FXMLLoader(getClass().getResource("Namskeid.fxml"));
        dLoader.load();
        return dLoader.getController();
    }

    /**
     * Handler fyrir að eyða námskeiði
     * @param ignored ónotað
     */
    @FXML
    private void eydaNamskeidiHandler(ActionEvent ignored) {
        kennsluskra.eydaNamskeidi(virkurIndex);
    }

    /**
     * Handler fyrir skoða hnappinn. Birtir námskeið í sér glugga
     * @param ignored ónotað
     */
    @FXML
    private void skodaNamskeidHandler(ActionEvent ignored) {
        skodaNamskeid(virkurIndex);
    }


    /**
     * Birtir námskeið i í sérglugga
     * @param i númer námskeiðs
     */
    private void skodaNamskeid(int i) {
        namskeidController.birtaGluggi(
                kennsluskra.getNamskeid(i));
    }
}

