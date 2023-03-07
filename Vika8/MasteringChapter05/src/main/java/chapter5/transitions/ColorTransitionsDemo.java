/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package chapter5.transitions;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sgrinev
 *
 * Skýringum bætt við af Ebbu Þóru Hvannberg
 */
public class ColorTransitionsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Hringur búinn til
        Shape circle = new Circle(50, 150, 50);

        // FillTransition klasinn er í Animation pakkanum. Hann erfir frá Transition klasanum sem aftur erfir frá Animation
        // Aðrir áhugaverðir Transition klasar eru t.d. FadeTransition (Dofna/Bjartara), PathTransition (færa sig eftir slóð), ScaleTransition (stækka/minnka)
        // Lengdin á breytingunni, hluturinn (circle) sem transition er beitt á, fyllt frá fyrri litnum og yfir í seinni litinn
        FillTransition ft = new FillTransition(Duration.seconds(10), circle, Color.RED, new Color(0, 0, 1, 0.5));

        // allt þetta venjulega
        Scene scene = new Scene(new Pane(circle), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // spila transitionina - þetta má setja í handler eða hvar sem
        ft.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
