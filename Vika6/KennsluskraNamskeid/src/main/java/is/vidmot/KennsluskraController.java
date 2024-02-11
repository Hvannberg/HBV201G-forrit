
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
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class KennsluskraController  {

    // Vinnsluhlutinn með gögnunum
    private Kennsluskra kennsluskra;
    private int virkurIndex=0;

    // Viðmótshlutir
    @FXML
    private ListView<Namskeid> listiNamskeid;

    // Controller fyrir Námskeið
    private NamskeidController namskeidController;


    public void initialize() {
        kennsluskra = new Kennsluskra();
        listiNamskeid.setItems(kennsluskra.getOllNamskeid());

        listiNamskeid.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           System.out.println (newValue);
            // Indexinn í listanum.
            virkurIndex = listiNamskeid.getSelectionModel().getSelectedIndex();
            // Til að fá virkni sem skoðar námskeiðið þegar valið breytist þá má gera það svona
            skodaNamskeid(virkurIndex);
        });

        try {
            namskeidController= hladaGluggi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private NamskeidController hladaGluggi() throws IOException {
        FXMLLoader dLoader = new FXMLLoader(getClass().getResource("Namskeid.fxml"));
        dLoader.load();
        return dLoader.getController();
    }




    @FXML
    private void eydaNamskeidiHandler(ActionEvent event) {
        if (virkurIndex != -1)
            kennsluskra.eydaNamskeidi(virkurIndex);
    }

    /**
     * Handler fyrir skoða hnappinn. Birtir námskeið í sér glugga
     * @param event
     */
    @FXML
    private void skodaNamskeidHandler(ActionEvent event) {
        if (virkurIndex != -1)
            skodaNamskeid(virkurIndex);
    }


    /**
     * Birtir námskeið i í sérglugga
     * @param i númer námskeiðs
     */
    private void skodaNamskeid (int i) {
        namskeidController.birtaGluggi(
                kennsluskra.getNamskeid(i));
    }
    }

