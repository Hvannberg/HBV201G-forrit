module hi.verkefni.daemimaven {
    requires javafx.controls;
    requires javafx.fxml;

    opens hi.verkefni.daemimaven to javafx.fxml;
    exports hi.verkefni.daemimaven;
}
