package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Vinnsluklasi fyrir lista sem hægt er að vakta og teljara sem heldur utan um heiltölu sem er bætt við á listann
 */
public class Listi {

    // Hér er listi af strengjum (String) sem hægt er að vakta  en þetta gæti verið listi af hvaða klasa sem er
    private final ObservableList<String> listiStrengir = FXCollections.observableArrayList();

    private int teljari;

    /**
     * Bætir við staki á listann
     * @param s
     */
    public void add(String s) {
        listiStrengir.add(s);
    }

    /**
     * Tekur elsta stakið af listanum og skilar því
     * @return
     */
    public String remove () {
        if (listiStrengir.size() >0) {
            String t = listiStrengir.get(0);
            listiStrengir.remove(0, 1);
            return t;
        }
        return "";
    }

    /**
     * Nær í vaktaða listann
     * @return
     */
    public ObservableList<String> getObs() {
        return listiStrengir;
    }

    /**
     * Hækkar teljarann og skilar gildinu
     * @return
     */
    public int haekka() {
        return ++teljari;
    }

    /**
     * Nær í teljarann
     * @return
     */
    public int getTeljari() {
        return teljari;
    }
}
