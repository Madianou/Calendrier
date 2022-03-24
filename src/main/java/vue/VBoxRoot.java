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

import java.util.Calendar;
import java.util.Collection;

public class VBoxRoot extends VBox
        implements ConstantesCalendrier {
    public VBoxRoot(){
        CalendrierDuMois monthCalendar = new CalendrierDuMois(3,2022);
        System.out.println(monthCalendar);

        Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
        VBox.setMargin(labelTitle, new Insets(14));

        VBox boiteDates = new VBox();
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(boiteDates);
        VBox.setMargin( scrollPaneDates, new Insets(4));
        DateCalendrier ajd = new DateCalendrier();

        for (DateCalendrier date: monthCalendar.getDates()) {
            if (date.getMois() == monthCalendar.getMois()) {
                Label tempLabel = new Label(date.toString());
                if (ajd.compareTo(date) == 0) {
                    tempLabel.setId("today");
                }
                VBox.setMargin(tempLabel, new Insets(4));
                boiteDates.getChildren().add(tempLabel);
            }
        }
        this.getChildren().addAll(labelTitle,scrollPaneDates);
    }
}
