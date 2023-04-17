module is.textirotate {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.textirotate.vidmot to javafx.fxml;
    exports is.textirotate.vidmot;
}