package is.vinnsla;

/**
 * @author Ebba Þóra Hvannberg
 */
public class NafnaBanki {
    private final String[] ollNofn; // nöfnin í nafnabankanum
    private int naestaLausa;    // næsta lausa slott fyrir nafn

    public NafnaBanki() {
        ollNofn = new String[5];
    }

    /**
     * Bætir við nafni í fylki
     *
     * @param s nafn
     * @return skilar true ef hægt er að bæta við nafni annars false
     */
    public boolean geymaNafn(String s) {
        if (naestaLausa < ollNofn.length) {
            ollNofn[naestaLausa++] = s;      // geymum nafnið
            return true;
        }
        return false;
    }
}
