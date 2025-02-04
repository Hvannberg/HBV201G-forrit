package vinnsla;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Vinnsluklasi fyrir sýniforritið
 *
 *
 *****************************************************************************/
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Audio {

    // er lag í spilun?
    private final SimpleBooleanProperty isPlayingProperty = new SimpleBooleanProperty(false);

    // nafn á lagi
    private final SimpleStringProperty lagProperty = new SimpleStringProperty();

    // hve oft er búið að spila
    private final SimpleIntegerProperty fjoldiProperty = new SimpleIntegerProperty();

    /**
     * Smiður sem býr til lag
     * @param lag nafn á lagi
     */
    public Audio(String lag ) {
        lagProperty.set(lag);
    }

    /**
     * Spilar lag er satt. Bætir einum við fjölda spilana
     */
    public void spila() {
        fjoldiProperty.set(fjoldiProperty.get() + 1);
        isPlayingProperty.set(true);
    }

    /**
     * Spilar lag er ósatt.
     */
    public void pasa() {
        isPlayingProperty.set(false);
    }

    /**
     * skilar isPlayingProperty
     *
     * @return isPlayingProperty
     */
    public SimpleBooleanProperty isPlayingProperty() {
        return isPlayingProperty;
    }

    /**
     * skilar playingProperty
     *
     * @return playingProperty
     */
    public SimpleStringProperty lagProperty() {
        return lagProperty;
    }

    /**
     * skilar fjoldiProperty
     *
     * @return fjoldiProperty
     */
    public SimpleIntegerProperty fjoldiProperty() {
        return fjoldiProperty;
    }
}
