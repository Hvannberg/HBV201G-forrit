

package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Hefur töflu með tveimur línum og samtölu þeirra
 * Sýnir hvernig hægt er að nota property inn í klasa
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 * Háskóli Íslands
 */
public class Blad {

    private static final int GENGI = 10;
    private final SimpleIntegerProperty tala;

    /**
     * Smiður sem býrt til Integer property sem hefur töluna 0
     */
    public Blad () {
        tala = new SimpleIntegerProperty(0);
    }


    public SimpleIntegerProperty talaProperty() {
        return tala;
    }


    public void reikna(int s) {
        tala.setValue(s*GENGI);
    }
}
