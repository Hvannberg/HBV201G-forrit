package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Dæmi um MediaPlayer - Stýriklasinn
 *
 *
 *****************************************************************************/

public class MediaController {

    public static final String HLJODSKRA = "media/sample-15s.wav";

    // tilviksbreytur - spilarinn
    private MediaPlayer mediaPlayer; // munið að bæta við dependency í pom.xml skrá og í module-info.java

    // kallað á þessa aðferð eftir að .fxml skrá er lesin inn
    // MediaPlayer frumstilltur
    public void initialize() {
        //  munið að bæta við dependency í pom.xml skrá og í module-info.java
        // hér er búinn til MediaPlayer með nafni á hljóðskrá sem pakkað er inn í Media hlut
        // það er ekki hægt að setja nýtt Media í MediaPlayer og þess vegna þarf að búa til nýjan MediaPlayer þegar nýtt lag er spilað
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource(HLJODSKRA).toExternalForm()));

    }

    /**
     * Handler fyrir play hnappinn - spilar hljóðskrána frá því sem hann hætti
     * @param actionEvent
     */
    @FXML
    protected void onPlay(ActionEvent actionEvent) {
        mediaPlayer.play();
    }

    /**
     * Handler fyrir pause hnappinn - pásar hljóðskrána
     * @param actionEvent
     */
    @FXML
    protected void onPause(ActionEvent actionEvent) {
        mediaPlayer.pause();
    }
}