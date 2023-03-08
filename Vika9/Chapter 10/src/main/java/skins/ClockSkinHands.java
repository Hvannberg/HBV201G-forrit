/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package skins;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Skin;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

/**
 *
 * Býr til klukku með kls, mínútu og sek vísum
 * @author sgrinev
 */
public class ClockSkinHands extends StackPane implements Skin<ClockControl> {

    private final ClockControl control;
    @FXML
    private Rotate rotateSecondHand;
    @FXML
    private Rotate rotateMinuteHand;
    @FXML
    private Rotate rotateHourHand;

    @FXML
    private Path hourHand;
    @FXML
    private Path minuteHand;
    @FXML
    private Line secondHand;

    public ClockSkinHands(ClockControl control) {
        this.control = control;
        FXML_Lestur.lesa (this, "hands-view.fxml");
        setMinSize(200, 200);
        hourHand.setTranslateX(hourHand.getBoundsInLocal().getWidth()/2);
        minuteHand.setTranslateX(minuteHand.getBoundsInLocal().getWidth() / 2);
        secondHand.setTranslateX(secondHand.getBoundsInLocal().getWidth() / 2);

        // binding hands to the model value
        control.timeProperty().addListener((e, oldValue, newValue) -> {
                    rotateSecondHand.setAngle(newValue.getSeconds() * 6 - 90);
                    rotateMinuteHand.setAngle(newValue.getMinutes() * 6 - 90);
                    rotateHourHand.setAngle(newValue.getHours() * 30 - 90);
                });
    }

    // Hér eru aðferðir sem eru skilgreindar í interface-inu og forritaðar
    // í þessum klasa
    @Override
    public ClockControl getSkinnable() {
        return control;
    }

    @Override
    public Node getNode() {
        return this;
    }

    @Override
    public void dispose() {
    }
}
