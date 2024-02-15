package is.mediademo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
/**
 * MediaPlayer demo by Liang - chapter 16
 * adapted to .fxml
 */

public class MediaDemoController {
    public MediaView fxMediaView;
    public Slider fxSlVolume;
    private MediaPlayer mediaPlayer;
    private static final String MEDIA_URL =
            "https://liveexample.pearsoncmg.com/common/sample.mp4";

    public void initialize() {
        mediaPlayer = new MediaPlayer(new Media(MEDIA_URL));
        mediaPlayer.setAutoPlay(false);
        fxMediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.volumeProperty().bind(
                fxSlVolume.valueProperty().divide(100));
    }

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

    public void rewindAction(ActionEvent actionEvent) {
        mediaPlayer.seek(Duration.ZERO);

    }
}
