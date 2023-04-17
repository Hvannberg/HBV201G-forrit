module is.teikning {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.teikning.vidmot to javafx.fxml;
    exports is.teikning.vidmot;
}