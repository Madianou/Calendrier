package vue;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class GraphiqueDate extends Application {

    public void start(Stage stage) {
        //VBox root = new VBoxRoot();
        VBox root = new VBoxRootAllMonths2();
        Scene scene = new Scene(root, 590, 425);
        File [] fichierCss = new File("css").listFiles();
        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
