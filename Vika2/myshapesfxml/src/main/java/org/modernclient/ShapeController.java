/******************************************************************************
 *  Nafn    : The Definitive Guide to Modern Java CLients with JavaFX
 * T-póstur: aðlagað af ebba@hi.is
 *
 * Lýsing  : Stýring fyrir forritið. Músarsmellur sýnir source og target hluti sem fylgja atburðinum
 *
 *****************************************************************************/


package org.modernclient;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class ShapeController {
    @FXML
    private Text fxTextSource;
    @FXML
    private Text fxTextTarget;

    public void handleMouseClick(MouseEvent mouseEvent) {
        fxTextSource.setText(fxTextSource.getText()+"\n"+"Source hlutur "+mouseEvent.getSource().getClass());
        fxTextTarget.setText("Target hlutur "+mouseEvent.getTarget().getClass());

    }
}
