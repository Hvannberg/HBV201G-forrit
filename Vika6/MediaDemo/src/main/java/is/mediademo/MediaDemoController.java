package is.mediademo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

/**
 * MediaPlayer demo by Liang - chapter 16
 * adapted to .fxml
 */

public class MediaDemoController {
    // viðmótið
    public MediaView fxMediaView; // eingöngu birtingin (rendering) á myndbandinu
    public Slider fxSlVolume;
    public StackPane fxStackPane;

    // vinnslan
    private MediaPlayer mediaPlayer; // öll virknin fer fram hér
    
    private Media media;
    private static final String MEDIA_URL =
            "https://liveexample.pearsoncmg.com/common/sample.mp4";

    /**
     * Frumstillir controllerinn. Býr til vinnsluhlut MediaPlayer
     * tengir mediaPlayer við media view.
     * bindur volume property við volume hnappinn.
     */
    public void initialize() {
      newMediaPlayer(MEDIA_URL);
    }

    /**
     * Búinn til nýr media player með mediaURL myndskeiði
     *
     * @param mediaURL slóðin á myndskeiðinu
     */
    private void newMediaPlayer(String mediaURL) {
        mediaPlayer = new MediaPlayer(new Media(mediaURL)); // nýr mediaPlayer búinn til með ákveðinni media skrá
        // hægt að nota FileChooser til að ná í slóðina á skránni
        mediaPlayer.setAutoPlay(true);
        fxMediaView.setMediaPlayer(mediaPlayer);
        // bindur volume-ið á media player við volume hnappinn
        mediaPlayer.volumeProperty().bind(
                fxSlVolume.valueProperty().divide(100));
    }

    /**
     * Stýring fyrir play/pause takkann. Fer úr stöðunni pause í play og úr play í pause.
     *
     * @param actionEvent atburðurinn notaður til að ná í play/pause hnappinn - athugið er ekki tilviksbreyta
     */
    public void playPauseAction(ActionEvent actionEvent) {
        Button playButton = (Button) actionEvent.getSource();
        System.out.println(playButton.getText());

        if (playButton.getText().equals(">")) {
            mediaPlayer.play();
            System.out.println("play " + mediaPlayer.getStatus());
            playButton.setText("||");
        } else {
            mediaPlayer.pause();
            System.out.println("pause " + mediaPlayer.getStatus());
            playButton.setText(">");
        }
    }

    /**
     * Handler til að rewind-a í byrjun
     * @param ignored ónotað
     */
    public void rewindAction(ActionEvent ignored) {
        mediaPlayer.seek(Duration.ZERO);
    }

    /**
     * Handler til að opna video. Ef video er þegar í keyrslu er það stoppað.
     * MediaView er bundinn við stærðina á umlykjandi StackPane
     * @param ignored
     */
    @FXML
    public void onOpenVideo(ActionEvent ignored) {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Media File");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            newMediaPlayer(file.toURI().toString());
        }
        fxMediaView.fitHeightProperty().bind(fxStackPane.heightProperty());
        fxMediaView.fitWidthProperty().bind(fxStackPane.widthProperty());

    }
}
