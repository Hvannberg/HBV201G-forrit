module hi.verkefni.vidmot{
    requires javafx.controls; // þarf javafx.controls módúl
    requires javafx.fxml;    // þarf  javafx.fxml módul

    opens hi.verkefni.vidmot to javafx.fxml; // leyfir javafx.fxml að
                                             // skoða vidmot pakka
    exports hi.verkefni.vidmot to javafx.graphics;
}
