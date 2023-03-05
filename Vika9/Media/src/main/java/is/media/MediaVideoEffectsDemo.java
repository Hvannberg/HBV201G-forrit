/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package is.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class MediaVideoEffectsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // settu hér  skrá að eigin vali
        Media media = new Media(getClass().getResource("sample-5s.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        FloatMap floatMap = new FloatMap();
        floatMap.setWidth(320);
        floatMap.setHeight(240);

        for (int x = 0; x < 320; x++) {
            double v = Math.sin(x / 30.) / 10.;
            for (int y = 0; y < 240; y++) {
                floatMap.setSamples(x, y, 0.0f, (float) v);
            }
        }

        DisplacementMap displacementMap = new DisplacementMap();
        displacementMap.setWrap(true);
        displacementMap.setMapData(floatMap);
        mediaView.setEffect(displacementMap);

        primaryStage.setTitle("VideoSpectrumDemo");
        primaryStage.setScene(new Scene(new Pane(mediaView), 320, 240));
        primaryStage.show();
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
