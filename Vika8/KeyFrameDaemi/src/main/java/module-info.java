module is.vidmot {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports is.vidmot to javafx.graphics, javafx.fxml;
    opens is.vidmot to javafx.fxml;
}