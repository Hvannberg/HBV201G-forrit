module is.hreyfimyndir {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.hreyfimyndir.vidmot to javafx.fxml;
    exports is.hreyfimyndir.vidmot;
}