/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.international.vidmot;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aðalforrit fyrir alþjóðlegt notendaviðmót
 * Hægt að skipta á milli ensku og íslensku
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class AlthjodaMain extends Application {
    // Hér mætti endurskrifa og nota afbrigði af ViewSwitcher en með resource bundle
    public static Parent rootEnskt;
    public static Parent rootIsl;
    @Override
    public void start(Stage stage) throws Exception {
        // Setjum upp tvö mismunandi scene graf fyrir 
        // tvö málsvæði 
        rootEnskt = FXMLLoader.load(getClass().getResource("Synidaemi.fxml"),
                ResourceBundle.getBundle("is.international.vidmot.texti",
                        new Locale("en","GB")));
        rootIsl = FXMLLoader.load(getClass().getResource("Synidaemi.fxml"),
                ResourceBundle.getBundle("is.international.vidmot.texti",
                        new Locale("is")));
        // Enska svæðið er það sjálfgefna
        
        Parent root = rootEnskt;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
