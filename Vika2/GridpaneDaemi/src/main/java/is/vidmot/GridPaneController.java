package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
/**
 * Sýnidæmi um GridPane - ccontroller
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */


public class GridPaneController {
    public GridPane fxGridPane;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) {

        Button b = (Button) actionEvent.getSource();
        welcomeText.setText("Dæmi um GridPane");
    }

    public void onButtonClick(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        int i=GridPane.getRowIndex(b);
        int j = GridPane.getColumnIndex(b);
        System.out.println ("röð "+ i+ " og dálkur "+ j);
    }
}