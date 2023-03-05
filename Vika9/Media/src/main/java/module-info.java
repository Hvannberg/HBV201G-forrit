module is.media {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;

    opens is.media to javafx.fxml, javafx.media, javafx.graphics;
}