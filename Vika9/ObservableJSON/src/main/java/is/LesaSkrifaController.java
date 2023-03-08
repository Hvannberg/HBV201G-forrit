package is;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vinnsla.Bilnumer;
import vinnsla.Car;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LesaSkrifaController {
    @FXML
    private Label fxType;
    @FXML
    private Label fxColor;
    @FXML
    private Label welcomeText;
    private static final String filename = "target/classes/is/cars.json";

    public void initialize() {

    }
    /**
     * Skrifar lista af hlutum í nýja skrá.
     * Ef skrá er til gerist ekki neitt
     */
    @FXML
    protected void onVistaButtonClick() {
        welcomeText.setText("Gögn vistuð");
        ObjectMapper objectMapper = new ObjectMapper();
        Car[] cars = new Car[2];
        ObservableList<Bilnumer> bilnumer = FXCollections.observableArrayList();
        bilnumer.add(new Bilnumer(3));
        bilnumer.add (new Bilnumer(4));
        cars[0] = new Car("yellow", "renault", bilnumer);
        cars[1] = new Car("red", "volvo", bilnumer);

        // sýnum bindingu á color við viðmótið
        fxColor.textProperty().bind (cars[0].colorProperty());

        try {
               File file = new File(filename);
               if (file.createNewFile())
                objectMapper.writeValue(file, cars);
            else {
                System.out.println("skráin er til");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Les hluti úr skrá og býr til java hluti. Er handler
     * @param actionEvent atburðurinn
     */
    public void onLesaButtonClick(ActionEvent actionEvent) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Gögnin sem mætti breyta t.d.
            List<Car> listCar = objectMapper.readValue(
                    new File(filename),
                    new TypeReference<>() {
                    });
            System.out.println(listCar);

            fxColor.textProperty().bind(listCar.get(0).colorProperty());
        } catch (IOException e) {
            System.out.println ("skrá er ekki til "+e.getMessage());
        }
    }
}
