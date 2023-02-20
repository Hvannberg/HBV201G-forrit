module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.vidmot to javafx.fxml;
    exports is.vidmot;
    exports is.vinnsla;
    opens is.vinnsla to javafx.fxml;
}