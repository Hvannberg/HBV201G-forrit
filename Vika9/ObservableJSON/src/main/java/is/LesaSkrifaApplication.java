package is;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Hér má hlaða niður Jackson library
// https://search.maven.org/search?q=g:com.fasterxml.jackson.core%20AND%20a:jackson-annotation

// Dæmið er skrifað með fyrirmynd frá Baeldung héðan
// https://www.baeldung.com/jackson-object-mapper-tutorial

public class LesaSkrifaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LesaSkrifaApplication.class.getResource("lesaSkrifa-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Vista í skrá ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
