package com.example.dialogdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.util.Optional;

public class MainController {


    public BorderPane root;
    @FXML
    private Button addButton;

    @FXML
    private ListView listView;

    public void initialize() {
        addButton.setOnAction(event -> { //lambda fall fyrir event handler
            Dialog<Person> personDialog = new PersonDialog(new Person("", ""));

            Optional<Person> result = personDialog.showAndWait();
            if (result.isPresent()) {
                Person person = result.get();
                listView.getItems().add(person.getFirstName() + " " + person.getLastName());
            }
        });
    }
}
