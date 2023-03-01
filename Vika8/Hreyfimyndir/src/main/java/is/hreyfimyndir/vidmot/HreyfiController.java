/**
 * Sýnidæmi fyrir Hreyfimynd - Controller
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
package is.hreyfimyndir.vidmot;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HreyfiController {
    // fastar
    @FXML
    private Rectangle fxRectangle; // rétthyrningur sem hreyfist
    @FXML
    private Pane fxPane;
    @FXML
    private Button fxHnappur;   // Hnappur sem hreyfist
    private final Random rand = new Random();   // Random generator

    public void initialize() {
        stillaTimeline();                               // setur upp hreyfilykkjuna
    }

    /**
     * Setur upp hreyfilykkju til að hreyfa hnapp og rétthyrning
     */
    private void stillaTimeline () {
        KeyFrame k = new KeyFrame(Duration.millis(1000),    // hvert tímabil er 1000 millisek.
                e-> {  // lambda fall sem er kallað á þegar ActionEvent atburðurinn er fíraður í lok
                       // hvers tímabils

                    leikjaSkref();
                });
        Timeline t = new Timeline(k);           // tengjum timeline og tímabilið
        t.setCycleCount(Timeline.INDEFINITE);   // hve lengi tímalínan keyrist
        t.play();                               // setja tímalínuna af stað
    }

    private void leikjaSkref() {
        // rétthyrningur færist - færslurnar geymast
       fxRectangle.getTransforms().add(new Translate(5,5));
        // hnappurinn er færður til um random gildi
        fxHnappur.relocate(rand.nextInt((int)(fxPane.getWidth()-fxHnappur.getWidth())),
                rand.nextInt((int)(fxPane.getHeight()-fxHnappur.getHeight())));
    }
}
