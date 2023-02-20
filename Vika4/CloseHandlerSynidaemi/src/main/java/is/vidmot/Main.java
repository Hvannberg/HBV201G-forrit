package is.vidmot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    // nefndir fastar í staðinn fyrir að hafa strengi út um allt forrit
    private static final String NAFNFORRITS="Close handler dæmi"; // fasti fyrir gluggann
    private static final String SPURNING="Viltu hætta?";
    private static final String TILKYNNING="Hætta í forriti";
    private static final String ILAGI ="Í lagi";
    private static final String HAETTAVID = "Hætta við";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root =   FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        lokaGluggaHandler(primaryStage);    // Tengja Alert dialog við að loka þessum glugga
        primaryStage.show();
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

    /**
     * Setur upp handler fyrir að loka glugga
     * @param stage glugginn
     */
    private void lokaGluggaHandler(Stage stage) {
        stage.setOnCloseRequest(event -> {
            // Opna Alert glugga
            ButtonType bType = new ButtonType(ILAGI,
                    ButtonBar.ButtonData.OK_DONE);
            ButtonType hType = new ButtonType(HAETTAVID,
                    ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert a = stofnaAlert(bType, hType);
            // Bíða eftir svarinu
            Optional<ButtonType> svar = a.showAndWait();
            if (svar.isPresent() && svar.get() == bType) {  // Ef svarið er í lagi
                Platform.exit();                            // loka forritinu
                System.exit(0);
            } else                                          // annars halda áfram
                event.consume();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
