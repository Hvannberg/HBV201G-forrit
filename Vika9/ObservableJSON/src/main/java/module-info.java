module is.observablejson {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens is to javafx.fxml, javafx.graphics;
    exports vinnsla to com.fasterxml.jackson.databind;
}