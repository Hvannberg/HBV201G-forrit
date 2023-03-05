/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package is.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MediaAudioDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int MID = 50;

        Pane root = new Pane();
        Line[] lines = new Line[128];
        for (int i = 0; i < 128; i++) {
            Line line = new Line(5 + i*3, MID, 5 + i*3, MID);
            lines[i] = line;
            root.getChildren().add(line);
        }
// settu hér  skrá að eigin vali
        Media media = new Media("https://github.com/sgrinev/mastering-javafx-9-10-book/raw/master/resources/808-beat.mp3");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setAudioSpectrumListener((timestamp, duration, magnitudes, phases) -> {
            System.out.print(timestamp + " " + magnitudes[6]);
            for (int i = 0; i < Math.max(128, magnitudes.length); i++) {
                lines[i].setEndY(MID - magnitudes[i] + mp.getAudioSpectrumThreshold());
            }
        });

        primaryStage.setTitle("AudioSpectrumDemo");
        primaryStage.setScene(new Scene(root, 370, 100));
        primaryStage.show();
        mp.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
