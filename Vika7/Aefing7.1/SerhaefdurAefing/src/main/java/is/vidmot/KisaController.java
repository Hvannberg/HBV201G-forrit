package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Controller fyrir kisuforrit - getur eytt út myndum og sett inn nýja mynd
 *
 *****************************************************************************/

public class KisaController {
    @FXML
    private HBox fxKisur;

    private final Image[] myndir = new Image[3];


    /**
     * Les kisumyndir inn
     */
    private void lesaMyndir() {
        for (int i = 1; i < myndir.length + 1; i++) {
            String nafn = "myndir/kisa" + i + ".jpg";
            myndir[i - 1] = new Image(DyrSpjald.class.getResourceAsStream(nafn));
        }
    }

    /**
     * Upphafsstillir 3 nýjar kisumyndir
     */
    @FXML
    public void initialize() {
        lesaMyndir();
        for (int i = 0; i < fxKisur.getChildren().size(); i++) {
            ((DyrSpjald) fxKisur.getChildren().get(i)).setDyrMynd(myndir[i]);
        }
    }



    /**
     * Setur nýja mynd af kisu af handahófi í myndaramma af handahófi
     * Ef enginn kisumynd er sýnileg þá eru þær upphafsstilltar
     *
     * @param actionEvent ónotað
     */
    @FXML
    public void nyKisaHandler(ActionEvent actionEvent) {
            // setja kisumynd af handahófi á DyrSpjald "ramma" af handahófi
            int i = (int) (Math.random() * 3);
            int j = (int) (Math.random() * 3);
            ((DyrSpjald) fxKisur.getChildren().get(i)).setDyrMynd(myndir[j]);
    }
}
