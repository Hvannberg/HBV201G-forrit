package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    // nefndir fastar í staðinn fyrir að hafa strengi út um allt forrit
    private static final String NAFNFORRITS="Alert dialog dæmi"; // fasti fyrir gluggann
    private static final String SPURNING="Er þetta hættulegt?";
    private static final String TILKYNNING="Hætta á ferð";
    private static final String ILAGI ="Í lagi";
    private static final String HAETTAVID = "Hætta við";

    @Override
    public void start(Stage stage) throws IOException {
        // búum til tvo ButtonType hluti í forritinu í staðinn fyrir að gera það í .fxml skránni
        ButtonType bType = new ButtonType(ILAGI,
                ButtonBar.ButtonData.OK_DONE);
        ButtonType hType = new ButtonType(HAETTAVID,
                ButtonBar.ButtonData.CANCEL_CLOSE); // ButtonType er merktur með CANCEL_CLOSE (er enum)

        Alert a = stofnaAlert(bType, hType);
        a.showAndWait();    // birtum og bíðum en gerum ekkert við niðurstöðuna hér

    }

    /**
     * Birtir Alert glugga til að láta vita að hætta sé á ferð.
     * @param bILagi - Í lagi hnappurinn
     * @param bHaettaVid - hætta við hnappurinn
     * @return Alert glugginn
     */
    private Alert stofnaAlert(ButtonType bILagi, ButtonType bHaettaVid) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.NONE,  SPURNING, bILagi, bHaettaVid);
        a.setTitle(NAFNFORRITS);
        a.setHeaderText(TILKYNNING);
        return a;
    }


    public static void main(String[] args) {
        launch();
    }
}