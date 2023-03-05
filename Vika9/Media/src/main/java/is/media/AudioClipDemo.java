/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package is.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *
 * @author sgrinev
 */
public class AudioClipDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // settu hér  skrá að eigin vali
        AudioClip clickSound =
                new AudioClip(getClass().getResource("sample-15s.wav")
                        .toExternalForm());
        Button btn = new Button("Play");
        btn.setOnAction((e) -> {
            clickSound.play();
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
