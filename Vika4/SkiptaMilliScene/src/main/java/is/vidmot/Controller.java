package is.vidmot;
/**
 * Sýnidæmi - stýring fyrir að skipta á milli leikmanna
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import is.vinnsla.Leikmadur;

public class Controller  {
    // Viðmótshlutir

    @FXML
    private Label fxStig;
    @FXML
    private Button fxGera;
    @FXML
    private Label fxLeikmadur;

    // aðrar stýringar
    private Controller motherji;

    // Gagnahlutir
    private Leikmadur leikmadur;


    public void initialize() {
        System.out.println("Controller hluturinn er "+ this);

    }

    public void setLeikmadur (String nafn) {
        leikmadur = new Leikmadur (nafn);
    }

    public void setMotherjinn(Controller motherjinn) {
        this.motherji = motherjinn;
    }
    /**
     * Birtir nafn leikmans og setur focus á hnappinn til að gera
     */
    public void birtaNafnLeikmanns() {
        fxLeikmadur.setText(leikmadur.getNafn());
        fxGera.requestFocus();
    }

    /**
     * Handler fyrir að skipta yfir í hinn mótherjann
     * @param actionEvent ónotað
     */
    public void skiptaMotherja(ActionEvent actionEvent) {
        leikmadur.haekkaStig();
        fxStig.setText(leikmadur.getStig()+"");
        // náum í núverandi glugga
        Stage s = (Stage)fxLeikmadur.getScene().getWindow();

        // setjum senuna sem er tengd við mótherjann
        s.setScene(motherji.fxLeikmadur.getScene());
    }
}
