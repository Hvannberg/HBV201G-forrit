package is.vidmot;

import hi.verkefni.vinnsla.Vidburdur;
import javafx.fxml.FXML;

public class MainController {
    @FXML
    private DagurView fxDagurPane;

    public void initialize() {
        VidburdurView v = new VidburdurView(new Vidburdur());
        fxDagurPane.getChildren().add(v);
    }


    public void fxEydaVidburdi(VidburdurView vidburdurView) {
        // eyða Vidburdur v úr lista af viðburðum fyrir daginn - vinnsluhluti

        // eyða vidburdurView viðmótshluti úr deginum
        fxDagurPane.getChildren().remove(vidburdurView);

    }
}
