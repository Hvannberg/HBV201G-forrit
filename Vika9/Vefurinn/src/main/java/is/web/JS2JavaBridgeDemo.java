/*
 * (C) Packt Publishing Ltd, 2017-2018
 */
package is.web;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 *
 * @author sgrinev
 * Breytt af Ebbu Þóru Hvannberg í samræmi við þetta svar
 * https://stackoverflow.com/questions/55541775/java-swing-webengine-executescript-not-firing-within-html-javafx-webview
 */

public class JS2JavaBridgeDemo extends Application {

    // declaring root as a variable to have access to it from setColor() method
    StackPane root;

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        // here we have an HTML page with a text box and a button
        // pressing the button will take entered text value and
        // pass it to the JavaFX application
        webEngine.loadContent(
                  "<p><input type=text id='color' value='red'/>"
                + "<p><input type=button onclick=\"app.setColor(document.getElementById('color').value)\" value='Ýttu hér'>"
        + "<button onclick='app.haetta();' >Hætta</button>");
        webEngine.getLoadWorker().stateProperty().addListener((o, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) webView.getEngine().executeScript("window");
                window.setMember("app", this);
            }
        });

        root = new StackPane(webView);
        // adding padding to have visible part of the background
        root.setPadding(new Insets(10));
        primaryStage.setTitle("JavaFX JavaScript to JavaFX bridge demo");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    // this method we will be calling from JavaScript
    public void setColor(String param) {
        // taking parameter and apply it as a color to the background
        root.setStyle("-fx-background-color: " + param + ";");
        System.out.println (" setColor "+param);
    }

    public void haetta() {
        Platform.exit();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
