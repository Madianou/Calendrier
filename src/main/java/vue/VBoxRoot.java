package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

import java.util.Collection;

public class VBoxRoot extends VBox
        implements ConstantesCalendrier {
    public VBoxRoot(){
        //DateCalendrier dateAjd = new DateCalendrier();
        //DateCalendrier dateLend = dateAjd.dateDuLendemain();
        HBox entete = new HBox(10);
        Button suivant = new Button(">");
        Button precedent = new Button("<");
        entete.getChildren().addAll(precedent, suivant);
        StackPane calendrier = new StackPane();
        this.getChildren().add(entete);
        for (int i = 1; i<13;i++) {
            VBox contenu = new VBox(10);
            CalendrierDuMois mois = new CalendrierDuMois(i, 2022);
            Label labelmois = new Label(MOIS[mois.getMois() - 1] + " " + mois.getAnnee());
            labelmois.setId("titre");
            //VBox boxDate = new VBox();
            TilePane tilePaneDate = new TilePane();
            tilePaneDate.setHgap(20);
            tilePaneDate.setVgap(20);
            Collection<DateCalendrier> dates = mois.getDates();
            DateCalendrier dateAJd = new DateCalendrier();
            for (DateCalendrier date : dates) {
                if (date.getMois() == i) {
                    Label tempLabel = new Label(date.toString());
                    if (dateAJd.compareTo(date) == 0) {
                        tempLabel.setId("today");
                    }
                    VBox.setMargin(tempLabel, new Insets(4));
                    tilePaneDate.getChildren().add(tempLabel);
                }
            contenu.getChildren().addAll(labelmois,tilePaneDate);
            calendrier.getChildren().add(contenu);
            }
        }
        this.getChildren().add(calendrier);
        //ScrollPane scrollPaneDates = new ScrollPane();
        //scrollPaneDates.setContent(boxDate);
    }
}
