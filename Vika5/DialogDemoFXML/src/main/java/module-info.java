module com.example.dialogdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dialogdemo to javafx.fxml;
    exports com.example.dialogdemo;
    exports com.example.dialogdemo.vidmot;
    opens com.example.dialogdemo.vidmot to javafx.fxml;
    exports com.example.dialogdemo.vinnsla;
    opens com.example.dialogdemo.vinnsla to javafx.fxml;
}