package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Vinnsluklasi fyrir lista sem hægt er að vakta og teljara sem heldur utan um heiltölu sem er bætt við á listann
 */
public class Listi {

    // Hér er listi af strengjum (String) sem hægt er að vakta  en þetta gæti verið listi af hvaða klasa sem er
    private final ObservableList<LocalDate> listiStrengir = FXCollections.observableArrayList();

    private LocalDate teljari = LocalDate.now(); // hér verður "teljari" núverandi dagsetning


    /**
     * Bætir við staki á listann
     * @param s
     */
    public void add(LocalDate s) {
        listiStrengir.add(s);
    }

    /**
     * Tekur elsta stakið af listanum og skilar því
     * @return
     */
    public LocalDate remove () {
        if (listiStrengir.size() >0) {
            LocalDate t = listiStrengir.get(0);
            listiStrengir.remove(0, 1);
            return t;
        }
        return null;
    }

    /**
     * Nær í vaktaða listann
     * @return
     */
    public ObservableList<LocalDate> getObs() {
        return listiStrengir;
    }

    /**
     * Hækkar teljarann og skilar gildinu
     * @return
     */
    public LocalDate haekka() {
        teljari = teljari.plusDays(1);
        return teljari;
    }

    /**
     * Nær í teljarann
     * @return
     */
    public LocalDate getTeljari() {
        return teljari;
    }
}
