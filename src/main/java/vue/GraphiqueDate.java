package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class GraphiqueDate extends Application {

    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 700, 550);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        File css = new File("tp2_partie2/css"+File.separator+"premierStyles.css");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
