module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens vika7.vidmot to javafx.fxml;
    exports vika7.vidmot;
}