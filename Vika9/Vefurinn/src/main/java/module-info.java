module is.web {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jdk.jsobject;
    requires javafx.graphics;

opens is.web to javafx.fxml, javafx.graphics, javafx.web;
}