/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Sýnidæmi fyrir Bindings.when () .then (). otherwise()
 *            Stýringin fyrir sýnidæmið. Getur spilað og pásað á víxl
 *
 *
 *****************************************************************************/
package vidmot;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vinnsla.Audio;

import java.awt.event.ActionEvent;

public class AudioController {
    // viðmótshlutir
    @FXML
    private Label fxSpilar;

    // vinnslan
    private final Audio audio = new Audio("Take five");

    /**
     * Frumstillir notendaviðmótshluti eftir að .fxml skrá hefur verið lesin inn og viðmótshlutir búnir til
     */
    public void initialize() {
        fxSpilar.textProperty().bind(Bindings
                .when(audio.isPlayingProperty())
                .then(Bindings.concat("spilar ", audio.lagProperty(), " ", audio.fjoldiProperty()))
                .otherwise("pásar"));
    }


    /**
     * Handler fyrir spila hnappinn. Er eins og toggle, spilar ef er í pásu og pásar ef hann er að spila
     * @param actionEvent
     */
    public void onSpila(javafx.event.ActionEvent actionEvent) {
        if (audio.isPlayingProperty().get()) {
            audio.pasa();
        } else {
            audio.spila();
        }
    }
}