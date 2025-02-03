package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

public class Tala {

    // vöktuð breyta
    private final SimpleIntegerProperty tala = new SimpleIntegerProperty();

    public Tala(int tala) {
        this.tala.set(tala);
    }


    public SimpleIntegerProperty talaProperty() {
        return tala;
    }

    /**
     * Setur tölu sem tala
     * @param tala sem á að setja
     */
    public void setTala(int tala) {
        this.tala.set(tala);
    }

    /**
     * setur nýja random tölu 1 eða 2
     */
    public void nyTala () {
        setTala((int)(Math.random()*2) + 1);
    }
}
