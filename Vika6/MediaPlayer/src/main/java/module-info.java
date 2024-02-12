module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media; // bæta við javafx.media fyrir MediaPlayer

    opens is.vidmot to javafx.fxml, javafx.media; // bæta javafx.media við hér
    exports is.vidmot;
}