package is.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.util.Duration;
// frá Ed Eden-Rump
// https://edencoding.com/scene-background/#animating-backgrounds-using-css

public class BakgrunnurController {

    // fastar
    private static final int SEC = 200;
    private static final int ENDVALUE = -1500;

    @FXML
    private Region content; // VBox hluturinn

    /**
     * frumstillingaraðferð sem kallað er á eftir að .fxml skráin hefur verið lesin inn og viðmótshlutur settur í content tilviksbreytuna
     */
    public void initialize() {
        // Búinn til eiginleiki (property) sem hefur double gildi 0
        DoubleProperty xPosition = new SimpleDoubleProperty(0);

        // settur hlýðir (listener) sem vaknar þegar xPosition fær nýtt gildi og setur þá staðsetningu bakgrunnsins á content (Region hlutinn) sem nýja x hnitið
        xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(content, xPosition.get()));

        // tímalínan sett upp með tveimur römmum. Uppfærir xPosition sem aftur ræsir hlýðinn hér að ofan.
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)),
                new KeyFrame(Duration.seconds(SEC), new KeyValue(xPosition, ENDVALUE)) // xPosition breytir um gildi (interpolate) frá 0 til ENDVALUE (target) á tímanum SEC
        );
        // spila tímalínuna
        timeline.play();
    }

    /**
     * setur x hnitið á bakgrunna á region hlut
     * @param region svæðið
     * @param xPosition x hnitið
     */
    void setBackgroundPositions(Region region, double xPosition) {
        String style = getString(xPosition);
        region.setStyle(style);
    }

    /**
     * Færsla myndanna um x ásinn
     * @param xPosition x hnitið
     * @return stílnum (style)
     */
    private static String getString(double xPosition) {
        StringBuilder s= new StringBuilder();
        // 6 mismunandi myndir sem færast mismikið
        for (int i= 6; i>1; i--) {
            s.append("left ").append(xPosition / i).append("px bottom,");
        }
        s.append("left ").append(xPosition).append("px bottom;");
        return "-fx-background-position: " +  s;
    }
}