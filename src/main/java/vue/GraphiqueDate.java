package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class GraphiqueDate extends Application {

    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 550, 550);
        File [] fichierCss = new File("css").listFiles();
        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
