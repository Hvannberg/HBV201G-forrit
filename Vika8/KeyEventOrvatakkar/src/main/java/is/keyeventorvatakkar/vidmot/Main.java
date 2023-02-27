/**
 * Sýnidæmi fyrir KeyEvents - Aðalklasinn
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
package is.keyeventorvatakkar.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {


    // Býr til beinan aðgang frá KeyCode og í stefnu (enum). Hægt að nota til að fletta upp
    // stefnu (og gráðum) fyrir KeyCode
    private final HashMap<KeyCode, Stefna> map= new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sc = loader.getController();
        primaryStage.setTitle("Örvatakkar");
        Scene s = new Scene(root, 300, 275);
        orvatakkar(sc, s);          // tengir atburð frá örvatökkum við fall í controller
        primaryStage.setScene(s);
        primaryStage.show();
    }

    /**
     * Tengir örvatakka við fall sem á að keyra í controller
     * @param sc controllerinn
     * @param s  senan sem tekur við (consume) atburðinn
     */
    private void orvatakkar(Controller sc, Scene s) {
        // setjum upp beina aðganginn frá örvatökkunum og í hornið
        map.put(KeyCode.UP, Stefna.UPP);
        map.put(KeyCode.DOWN, Stefna.NIDUR);
        map.put(KeyCode.RIGHT, Stefna.HAEGRI);
        map.put(KeyCode.LEFT, Stefna.VINSTRI);
        s.addEventFilter(KeyEvent.ANY,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    // flettum upp horninu fyrir KeyCode í map
                    sc.setStefna(map.get(event.getCode()).getGradur());

                });
    }


    public static void main(String[] args) {
        launch(args);
    }
}



