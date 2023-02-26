module is.keyeventorvatakkar {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.keyeventorvatakkar.vidmot to javafx.fxml;
    exports is.keyeventorvatakkar.vidmot;
}