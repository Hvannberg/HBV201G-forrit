module is.json {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    exports is.json.vidmot;
    opens is.json.vidmot to javafx.fxml;
    exports is.json.vinnsla to com.fasterxml.jackson.databind;
}