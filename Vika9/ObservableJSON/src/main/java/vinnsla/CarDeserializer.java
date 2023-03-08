package vinnsla;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Iterator;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Búum til sér klasa sem les úr skrá fyrir hvern klasa sem inniheldur einhverja non-concrete klasa eins og ObservableList
 *  kóðinn er fenginn héðan https://groups.google.com/g/datafx-dev/c/H0DHTlMDtY8  frá Johan Vos 
 *****************************************************************************/
public class CarDeserializer extends JsonDeserializer<Car> {
    public CarDeserializer() {

    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        // Búum til hlut af klasanum sem við viljum lesa inn
        Car car = new Car();
        // JSON stuff
        ObjectMapper objectMapper = (ObjectMapper) parser.getCodec();
        // lesum tréð - node er rótin
        JsonNode node = objectMapper.readTree(parser);

        // setjum venjulegu gildin - tilviksbreyturnar eru tvær en gætu verið færri eða fleiri
        car.setType(node.get("type").asText());
        car.setColor(node.get("color").asText());

        // Bílnúmeralistinn - hér er einn listi en gætu verið fleiri
        JsonNode childNodes = node.get("bilnumerListi");
        ObservableList<Bilnumer> children = FXCollections.observableArrayList();

        // ítrum yfir stökin á listanum
        for (JsonNode childNode : childNodes) {
            Bilnumer child = new Bilnumer();    // búum til hlut fyrir hvert stak - gæti líka verið Integer, String o.s.frv.
            child.setBilnumer(childNode.get("bilnumer").asInt()); // hluturinn hefur bara eina tilviksbreytu hér en gætu haft fleiri
            children.add(child);    // söfnum hlutnum á listann
        }

        car.setBilnumerListi(children); // setjum listann inn í tilviksbreytuna

        return car; // skilum hlutnum
    }
}
