package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import vinnsla.Tala;


public class ImageController {
    // fastar
    private static final String[] myndir = {"one", "two"};

    // viðmótið
    @FXML
    private Button fxHnappur;

    // vinnslan
    Tala tala = new Tala(1);

    /*
        Frumstilling bindingar á milli viðmóts og vinnslu
     */
    public void initialize() {
        // vakta tölu í vinnsluna og uppfæra stíla á hnappnum til samræmis
        tala.talaProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    fxHnappur.getStyleClass().remove(myndir[oldValue.intValue() - 1]);
                    fxHnappur.getStyleClass().add(myndir[newValue.intValue() - 1]);
                });
    }

    /**
     * handler á hnapp sem setur random tölu í tala
     *
     * @param actionEvent
     */
    public void nyTalaHandler(ActionEvent actionEvent) {
        tala.nyTala();
    }
}