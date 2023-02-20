package vidmot;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Sýnidæmi fyrir TextInputDialog
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TextDialogController implements Initializable {

    private static final String I_LAGI = "Í lagi";
    private static final String HAETTA_VID = "Hætta við";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Textadialog búinn til
        TextInputDialog d = new TextInputDialog();

        // Settur titill og haus
        d.setTitle("Leikmenn");
        d.setHeaderText("Hvað heitirðu?");
        // Einfaldur texti sem meginmál
        d.setContentText("Nafn:");
        d.setGraphic (new ImageView(new Image(getClass().getResourceAsStream("myndir/tic.png"))));
        DialogPane pane = d.getDialogPane();

        // Sérsmíðaðir hnappar í sætum 0 og 1
        pane.getButtonTypes().set(0,new ButtonType(I_LAGI, ButtonBar.ButtonData.OK_DONE));
        pane.getButtonTypes().set(1,new ButtonType(HAETTA_VID, ButtonBar.ButtonData.CANCEL_CLOSE));

        // Birtum dialog-inn bíðum og fáum útkomuna
        // utkoma er af tagi sem inniheldur String
        Optional<String> utkoma = d.showAndWait();
        // Birtum svarið á console með því að nota get()
        if(utkoma.isPresent()) {
            System.out.println ("nafnið er "+utkoma.get());
        }
        else {
            System.out.println ("ekkert svar");
        }
        d.close();
    }
}
