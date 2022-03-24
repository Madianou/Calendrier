package vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRootAllMonths extends VBox implements ConstantesCalendrier {
    public VBoxRootAllMonths() {
        StackPane stackPaneMois = new StackPane();
        DateCalendrier ajd = new DateCalendrier();
        for (int i = 1; i <= 12; i++) {
            VBox contenu = new VBox();
            contenu.setId("test");
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i,2022);
            Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
            labelTitle.setId("titre");
            VBox.setMargin(labelTitle, new Insets(14));
            VBox boiteDates = new VBox();
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);
            VBox.setMargin(scrollPaneDates, new Insets(4));
            for (DateCalendrier date : monthCalendar.getDates()){
                if (date.getMois() == monthCalendar.getMois()) {
                    Label tempLabel = new Label(date.toString());
                    if (ajd.compareTo(date) == 0) {
                        tempLabel.setId("today");
                    }
                    VBox.setMargin(tempLabel, new Insets(4));
                    boiteDates.getChildren().add(tempLabel);
                }
                scrollPaneDates.setAccessibleText(MOIS[i-1]);
            }
            contenu.getChildren().addAll(labelTitle,scrollPaneDates);
            stackPaneMois.getChildren().addAll(contenu);
        }
        List<Node> listScrollPaneDate = stackPaneMois.getChildren();
        final int lastIndice = listScrollPaneDate.size()-1;
        while(! listScrollPaneDate.get(lastIndice).getAccessibleText().equals(MOIS[ajd.getMois()-1])){
            listScrollPaneDate.get(lastIndice).toBack();
        }
        this.getChildren().add(stackPaneMois);
    }
}