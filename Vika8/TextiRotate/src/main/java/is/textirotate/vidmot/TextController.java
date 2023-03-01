/**
 * Sýnidæmi fyrir Hreyfimynd - Controller
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
package is.textirotate.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class TextController {
    public static final int HORN = 90;
    public Text fxTexti;

    int hornMargfeldi=0;


    public void initialize() {
        stillaTimeline();                               // setur upp hreyfilykkjuna
    }

    /**
     * Setur upp hreyfilykkju til að hreyfa hnapp og rétthyrning
     */
    private void stillaTimeline() {
        KeyFrame k = new KeyFrame(Duration.millis(1000),    // hvert tímabil er 1000 millisek.
                e -> {  // lambda fall sem er kallað á þegar ActionEvent atburðurinn er fíraður í lok
                    // hvers tímabils

                    // fxTexti.getTransforms().add(new Rotate(90, 75, 100)); // snúa á öxli
                    fxTexti.setRotate(HORN * hornMargfeldi++); // snúa á miðju
                });
        Timeline t = new Timeline(k);           // tengjum timeline og tímabilið
        t.setCycleCount(Timeline.INDEFINITE);   // hve lengi tímalínan keyrist
        t.play();                               // setja tímalínuna af stað
    }
}
