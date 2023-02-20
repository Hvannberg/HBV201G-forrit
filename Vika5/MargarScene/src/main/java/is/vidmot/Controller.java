package is.vidmot;
/**
 * ******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : MargarScene - Stýriklasi - sýnir hvernig búnir eru til tveir gluggar með sitthvorri senunni
 *
 *
 *  *****************************************************************************
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {


    @FXML
    private Label fxNedri;
    @FXML
    private Label fxEfri;

    private Controller motherjinn;  // tilvísun í controller mótherjans


    public void initialize() {
        System.out.println("Controller hluturinn er "+ this);
    }

    public void fxNedriHandler(ActionEvent actionEvent) {
        ((Node)actionEvent.getSource()).setDisable(true);
        fxNedri.setText("Ýtt á");
    }
}
