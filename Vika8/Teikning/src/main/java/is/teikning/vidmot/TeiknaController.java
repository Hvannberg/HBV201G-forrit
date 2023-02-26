
package is.teikning.vidmot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Rectangle;

/**
 * Sýnidæmi fyrir teikningu
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TeiknaController  {

    @FXML
    private Canvas mittCanvas;
    @FXML
    private Pane gluggi;

    public void initialize() {

        // Hér er teiknaður rauður ferningur á canvas hlutinn
        GraphicsContext gc = mittCanvas.getGraphicsContext2D();
        gc.setStroke(RED);
        gc.strokeRect(2, 2, 40, 40);

        // Hér er teiknaður fylltur blár ferningur
        // á Pane hlutinn (gluggi)
        // Má líka gera í .fxml skránni
        Rectangle r = new Rectangle(2, 2, 40, 40);
        r.setFill(BLUE);
        r.setStroke(BLUE);
        // Bæta ferningnum við gluggi svo hann teiknist
        gluggi.getChildren().add(r);

        // Setjum handler á ferningshlutinn þannig að við framkvæmum
        // setningar þegar við drögum músina
        r.setOnMouseDragged(event->{  r.setX(event.getX());
            r.setY(event.getY());});

    }

}
