module TveirControllerar {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens is.hi.leikur.utlit;
    exports is.hi.leikur.utlit to javafx.graphics;
}