module com.example.multipleviews {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.almas.multipleviews to javafx.fxml;
    exports com.almas.multipleviews;
}