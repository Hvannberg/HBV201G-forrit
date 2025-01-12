package is.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class KeyFramesController {

    public Circle movingRED;
    public Circle movingOrange;
    @FXML
    private Circle movingBLUE;

    public void initialize() {

        KeyValue[] keyValues = {
                new KeyValue(movingOrange.translateXProperty(), 300),
                new KeyValue(movingBLUE.translateXProperty(), 500),
                new KeyValue(movingRED.translateXProperty(), 100)
        };

        // Þrjár mismunandi keyframes
        KeyFrame[] keyFrames = new KeyFrame[keyValues.length];
        for (int i = 0; i < keyValues.length; i++) {
            keyFrames[i] = new KeyFrame(Duration.seconds(50 + i * 100), keyValues[i]);
        }
        // 3 rammar settir upp á tímalínu
        Timeline timeline = new Timeline(keyFrames[0], keyFrames[1], keyFrames[2]);
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Spila tímalínuna
        timeline.play();
    }
}
