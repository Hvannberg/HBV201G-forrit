package vidmot.breytaborder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BorderController {


    @FXML
    private TextField fxTexti;

    @FXML
    protected void onRautt() {
        fxTexti.getStyleClass().removeAll("texti-green"); // fjarlægja græna styleClass
        fxTexti.getStyleClass().add("texti-red");              // bæta við rauða styleClass
    }

    @FXML
    protected void onGraent(ActionEvent actionEvent) {
       fxTexti.getStyleClass().removeAll("texti-red"); // fjarlægja rauða styleClass
       fxTexti.getStyleClass().add("texti-green");         // bæta við græna styleClass
    }
}