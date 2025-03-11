package hi.vinnsla;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Model klasi sem geymir tíma 0 til 23
 *
 *
 *****************************************************************************/

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalTime;

public class TimeModel {
    private final ObjectProperty<LocalTime> time = new SimpleObjectProperty<>(LocalTime.of(12, 0));

    public ObjectProperty<LocalTime> timeProperty() {
        return time;
    }

    public LocalTime getTime() {
        return time.get();
    }

    public void setTime(LocalTime newTime) {
        time.set(newTime);
    }
}
