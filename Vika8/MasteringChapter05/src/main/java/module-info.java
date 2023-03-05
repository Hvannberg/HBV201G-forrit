module chapter5.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens chapter5.app to javafx.fxml;
    exports chapter5.app;
    opens chapter5.basics to javafx.fxml;
    exports chapter5.basics;
    opens chapter5.transitions to javafx.fxml;
    exports chapter5.transitions;
}