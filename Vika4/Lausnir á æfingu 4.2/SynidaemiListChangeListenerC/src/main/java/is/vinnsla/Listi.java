package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Vinnsluklasi fyrir lista sem hægt er að vakta og teljara sem heldur utan um heiltölu sem er bætt við á listann
 */
public class Listi {

    // Hér er listi af strengjum (Pipa) sem hægt er að vakta  en þetta gæti verið listi af hvaða klasa sem er
    private final ObservableList<Pipa> listiStrengir = FXCollections.observableArrayList();

    private Pipa teljari = new Pipa (3, 4);

    /**
     * Bætir við staki á listann
     * @param s
     */
    public void add(Pipa s) {
        teljari = s;
        listiStrengir.add(s);
    }

    /**
     * Tekur elsta stakið af listanum og skilar því
     * @return
     */
    public Pipa remove () {
        if (listiStrengir.size() >0) {
            Pipa t = listiStrengir.get(0);
            listiStrengir.remove(0, 1);
            return t;
        }
        return null;
    }

    /**
     * Nær í vaktaða listann
     * @return
     */
    public ObservableList<Pipa> getObs() {
        return listiStrengir;
    }

    /**
     * Hækkar teljarann og skilar gildinu
     * @return
     */
    public Pipa haekka() {
        return new Pipa (teljari.getEitt()+1, teljari.getAnnad()+1);
    }

    /**
     * Nær í teljarann
     * @return
     */
    public Pipa getTeljari() {
        return teljari;
    }
}
