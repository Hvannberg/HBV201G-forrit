module hi.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens vidmot to javafx.fxml;
    exports vidmot;
}