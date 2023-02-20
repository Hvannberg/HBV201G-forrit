package is.vidmot;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField fxSimi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fxSimi.getStyleClass().add("text-field-stor");
    }
}
