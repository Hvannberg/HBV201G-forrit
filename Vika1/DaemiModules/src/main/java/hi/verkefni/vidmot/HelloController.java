package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.KlasiVinnsla;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    private KlasiVinnsla vinnsla;

    public void initialize() {
        vinnsla = new KlasiVinnsla(3,10, this);
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }
}
