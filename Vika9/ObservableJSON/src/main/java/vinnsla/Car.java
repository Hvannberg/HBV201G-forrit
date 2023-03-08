package vinnsla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  :
 *
 *
 *****************************************************************************/
@JsonDeserialize (using= CarDeserializer.class) // notum CarDeserializer til að lesa í klasann í staðinn fyrir sjálfgefn
public class Car {
    public StringProperty colorProperty() {
        return color;
    }

    private final StringProperty color = new SimpleStringProperty();
    private String type;

    private ObservableList<Bilnumer> bilnumerListi = null;

    public ObservableList<Bilnumer> getBilnumerListi() {
        return bilnumerListi;
    }


    public ObservableList<Bilnumer> bilnumerListiProperty() {
        return bilnumerListi;
    }

    public void setBilnumerListi(ObservableList<Bilnumer> bilnumerListi) {
        this.bilnumerListi = bilnumerListi;
    }


    public Car() {

    }


    public Car(String c, String t, ObservableList<Bilnumer> bilnumerListi) {
        this.color.set(c);
        type = t;
        this.bilnumerListi = bilnumerListi;
    }


    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
