package vidmot.breytaborder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BorderController {


    @FXML
    private TextField fxTexti;

    @FXML
    protected void onBreyta() {
        fxTexti.setStyle("-fx-border-color: red");
    }
}