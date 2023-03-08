module hi.chapterten {
    requires javafx.controls;
    requires javafx.fxml;


    opens skins to javafx.fxml;
    exports skins;
    exports chart;
}