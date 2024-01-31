package is.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

public class Vinnsla {

    private SimpleIntegerProperty fjoldi = new SimpleIntegerProperty(0);

    public Vinnsla (int fjoldi) {
        setFjoldi(fjoldi);
    }

    public int getFjoldi() {
        return fjoldi.get();
    }

    public SimpleIntegerProperty fjoldiProperty() {
        return fjoldi;
    }

    public void setFjoldi(int n) {
        this.fjoldi.set(n);
    }


    public void haekka() {
        fjoldi.set(fjoldi.get()+1);
    }

    public void laekka() {
        fjoldi.set(fjoldi.get()-1);
    }
}
