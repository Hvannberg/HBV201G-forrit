package is.vidmot;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    public TextField fxSimi;
    public Label nafn;


    public void initialize() {

        fxSimi.getStyleClass().add("text-field-stor"); // style er í EinfaldurCSS.css
    }
}
