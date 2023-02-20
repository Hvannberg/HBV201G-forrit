/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.vidmot;

import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * Sýnidæmi fyrir TextInputDialog 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TextDialogController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Textadialog búinn til 
        TextInputDialog d = new TextInputDialog();

        // Settur titill og haus 
        d.setTitle("Leikmenn");
        d.setHeaderText("Hvað heitirðu?");
        // Einfaldur texti sem meginmál 
        d.setContentText("Nafn:");

        // Birtum dialog-innm bíðum og fáum útkomuna 
        // utkoma er af tagi sem inniheldur String 
        Optional<String> utkoma = d.showAndWait();
        // Birtum svarið á console með því að nota get()
        if(utkoma.isPresent()) {
            System.out.println ("nafnið er "+utkoma.get());
        }
        else {
            System.out.println ("ekkert svar");
        }
        d.close();
    }  
}
