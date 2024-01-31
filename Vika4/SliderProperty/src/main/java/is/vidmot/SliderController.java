package is.vidmot;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderController {

    public Label fxLabel;
    public Slider fxSlider;


    public void initialize() {
        fxSlider.setValue(24);
        fxSlider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            fxLabel.setText("Font value: " + newvalue.toString());
            fxLabel.setStyle("-fx-font-size:" + newvalue.intValue() +";"+
                    "-fx-background-color:black; "+
            "-fx-text-fill:rgb(255,255,"+newvalue.intValue()/100.0*255+");");
        });
    }
}