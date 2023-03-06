module is.international {
    requires javafx.controls;
    requires javafx.fxml;


    exports is.international.vidmot;
    opens is.international.vidmot to javafx.fxml;
}