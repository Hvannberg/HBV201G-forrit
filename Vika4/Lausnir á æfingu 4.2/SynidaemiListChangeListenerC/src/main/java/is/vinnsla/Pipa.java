package is.vinnsla;

public class Pipa {

    private final int eitt;
    private final int ogAnnad;

    public Pipa (int x, int y) {
        eitt=x;
        ogAnnad=y;
    }
    public String toString() {
        return "eitt:" + eitt + " og  "+ "annad:"+ogAnnad;
    }

    public int getEitt() {
        return eitt;
    }

    public int getAnnad() {
        return ogAnnad;
    }
}
