/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.vidmot;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;


/**
 * Sýnidæmi fyrir TextInputDialog 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TextDialogController  {
    /**
     * Aðferð sem kallað er á eftir að búið er að lesa inn .fxml skrána
     * Textadialogur búinn til, hann opnaður og fengin gögn úr honum.
     */
    public void initialize() {
        // Textadialog búinn til 
        TextInputDialog d = new TextInputDialog();

        // Settur titill og haus 
        d.setTitle("Leikmenn");
        d.setHeaderText("Hvað heitirðu?");
        // Einfaldur texti sem meginmál 
        d.setContentText("Nafn:");

        // Birtum dialog-inn og bíðum og fáum útkomuna
        // utkoma er af tagi sem inniheldur String 
        Optional<String> utkoma = d.showAndWait();
        // Birtum svarið á console með því að nota get()
        if(utkoma.isPresent()) {
            System.out.println ("nafnið er "+utkoma.get());
        }
        else { // notandi ýtti á cancel
            System.out.println ("ekkert svar");
        }
        d.close();
    }  
}
