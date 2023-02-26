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

    private static final int UPP=90;
    private static final int NIDUR=270;
    private static final int VINSTRI=180;
    private static final int HAEGRI=360;

    // Býr til beinan aðgang frá KeyCode og í heiltölu. Hægt að nota til að fletta upp
    // heiltölu fyrir KeyCode
    private final HashMap<KeyCode, Integer> map= new HashMap<KeyCode,Integer>();

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
        map.put(KeyCode.UP, UPP);
        map.put(KeyCode.DOWN, NIDUR);
        map.put(KeyCode.RIGHT, HAEGRI);
        map.put(KeyCode.LEFT, VINSTRI);
        s.addEventFilter(KeyEvent.ANY,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    // flettum upp horninu fyrir KeyCode í map
                    sc.setStefna(map.get(event.getCode()));

                });
    }


    public static void main(String[] args) {
        launch(args);
    }
}



