package is.vidmot;

import is.vinnsla.Vinnsla;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VidmotVinnslaController {
    @FXML
    private Label fxStadan;

    @FXML
    private Label fxTala;

    private final Vinnsla vinnsla = new Vinnsla(3);

    public void initialize() {
        // binda fjölda í vinnslunni við notendaviðmótshlut (tala)
        fxTala.textProperty().bind(vinnsla.fjoldiProperty().asString());

        // binda fjölda í vinnslunni við notendaviðmóthlut (stadan)
        fxStadan.textProperty().bind(Bindings.createStringBinding(() -> {
            if (vinnsla.getFjoldi() < 0) {
                return "mínus";
            }
            else {
                return "plús";
            }
        }, vinnsla.fjoldiProperty()));
    }

    @FXML
    protected void onHaekka() {
        vinnsla.haekka();
    }

    @FXML
    protected void onLaekka() {
        vinnsla.laekka();
    }

}