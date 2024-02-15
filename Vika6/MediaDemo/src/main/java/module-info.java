module is.mediademo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens is.mediademo to javafx.fxml, javafx.media;
    exports is.mediademo;
}