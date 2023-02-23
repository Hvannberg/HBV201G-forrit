package is.vidmot;

import is.vinnsla.Listi;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

/**
 * Stýriklasinn stýrir tveimur aðgerðum frá notanda - bæta við staki (tölu) sem er hækkandi aftast á lista (röð) og eyða
 * staki fremst úr röð og birta
 */
public class ListiController {

    // viðmótsbreytur
    @FXML
    public TextArea fxListi;
    @FXML
    private Label fxNyr;

    private Listi listi;        // tengsl við vinnslusklasa forritsins


    /**
     * Frumstilla controller - vinnsluklasi smíðaður og búin til regla um hvernig viðmótið breytist þegar listinn breytist
     */
    public void initialize() {
        listi = new Listi(); // vinnsluklasi smíðaður

        // parameter í lambda fallið er change af klasanum https://openjfx.io/javadoc/19/javafx.base/javafx/collections/ListChangeListener.Change.html
        // hægt að spyrja nánar út í breytinguna t.d. change.wasAdded() til að sjá hvort staki var bætt við
        listi.getObs().addListener((ListChangeListener<String>) change -> {
            System.out.println("breyting " + listi.getTeljari());
            birta(listi);   // birtir listann í hvert skipti sem verður breyting á listanum
        });
    }

    /**
     * Birtir listann - allur listinn birtur aftur - höfum þetta einfalt hér
     * @param listi
     */
    private void birta(Listi listi) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < listi.getObs().size(); i++) {
            t.append(listi.getObs().get(i)).append("\n"); // þetta kemur í staðinn fyrir t=t+listi.getObs().get(i)+"\n";
        }
        fxListi.setText(t.toString());  // setur uppfærðan lista í fxListi
    }

    /**
     * Bætir við nýju staki - handler fyrir hnapp
     *
     * @param actionEvent
     */
    public void fxBaetaVidHandler(ActionEvent actionEvent) {
        listi.add(listi.haekka() + " "); // hækkar teljarann og bætir við á listann
    }

    /**
     * Eyðir af elsta stakinu - handler fyrir hnapp
     *
     * @param actionEvent
     */
    public void fxEydaHandler(ActionEvent actionEvent) {
        fxNyr.setText(listi.remove() + ""); // fjarlægir af listanum og uppfærir label viðmótshlut
    }
}