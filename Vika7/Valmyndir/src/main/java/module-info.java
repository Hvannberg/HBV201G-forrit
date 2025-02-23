/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : 
 *
 *
 *****************************************************************************/
module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens vidmot to javafx.fxml;
    exports vidmot to javafx.fxml, javafx.graphics;
}