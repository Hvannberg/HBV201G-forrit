package hi.vidmot;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Stýring fyrir viðmótið
 *
 *
 *****************************************************************************/

import hi.vinnsla.TimeModel;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.time.LocalTime;

public class SpinnerController {
    @FXML
    private Spinner<Integer> fxTime;
    private final TimeModel timeModel = new TimeModel();

    @FXML
    public void initialize() {
        // Búinn til Spinner með gildum frá 0 til 23, sjálfgefið 12
        fxTime.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12));

        // Þegar fxTime breytist -> Uppfærum timeModel
        fxTime.valueProperty().addListener((obs, oldVal, newVal) ->
                timeModel.timeProperty().set(LocalTime.of(newVal, 0)));

        // Þegar timeModel breytist -> Uppfærum Spinner
        timeModel.timeProperty().addListener((obs, oldTime, newTime) ->
                fxTime.getValueFactory().setValue(newTime.getHour()));
    }
}
