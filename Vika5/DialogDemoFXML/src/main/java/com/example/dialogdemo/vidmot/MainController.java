package com.example.dialogdemo.vidmot;

import com.example.dialogdemo.vinnsla.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.util.Optional;

public class MainController {


    public BorderPane root;

    @FXML
    private ListView<String> listView; // Hér hefði mátt setja ListView<Person>

     public void onAdd(ActionEvent actionEvent) {

        Dialog<Person> personDialog = new PersonDialog(new Person("", ""));
        Optional<Person> result = personDialog.showAndWait();
        if (result.isPresent()) {
            Person person = result.get();
            listView.getItems().add(person.getFirstName() + " " + person.getLastName());
        }
    }
}
