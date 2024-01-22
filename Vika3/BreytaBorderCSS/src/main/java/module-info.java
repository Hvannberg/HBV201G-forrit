module vidmot.breytaborder {
    requires javafx.controls;
    requires javafx.fxml;


    opens vidmot.breytaborder to javafx.fxml;
    exports vidmot.breytaborder;
}