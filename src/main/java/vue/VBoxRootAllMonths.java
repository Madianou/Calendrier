package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRootAllMonths extends VBox implements ConstantesCalendrier {
    public VBoxRootAllMonths() {

        StackPane stackPaneMois = new StackPane();
        DateCalendrier ajd = new DateCalendrier();

        StackPane stackPaneTitle = new StackPane();
        stackPaneTitle.setId("test");

        HBox top = new HBox(5);

        Button recul = new Button("<");
        Button avance = new Button(">");


        //bouton.setAlignment(Pos.CENTER_RIGHT);
        //HBox.setHgrow(bouton, Priority.ALWAYS);

        top.getChildren().addAll(stackPaneTitle,recul,avance);
        top.setAlignment(Pos.CENTER);
        this.getChildren().add(top);

        for (int i = 1; i <= 12; i++)
        {
            //VBox contenu = new VBox();
            //contenu.setId("test");

            CalendrierDuMois monthCalendar = new CalendrierDuMois(i,2022);
            Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
            labelTitle.setId("titre");
            labelTitle.setMinWidth(200);
            labelTitle.setAlignment(Pos.CENTER);

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
            }
            scrollPaneDates.setAccessibleText(MOIS[i-1]);
            stackPaneMois.getChildren().addAll(scrollPaneDates);
            stackPaneTitle.getChildren().add(labelTitle);
        }
        List <Node> listScrollPaneDate = stackPaneMois.getChildren();
        List <Node> listLabelTitle = stackPaneTitle.getChildren();
        System.out.println(listScrollPaneDate.toString());
        final int lastIndice = listScrollPaneDate.size()-1;
        while(! listScrollPaneDate.get(lastIndice).getAccessibleText().equals(MOIS[ajd.getMois()-1])){
            listScrollPaneDate.get(lastIndice).toBack();
            listLabelTitle.get(lastIndice).toBack();
        }

        recul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                listScrollPaneDate.get(lastIndice).toBack();
                listLabelTitle.get(lastIndice).toBack();
            }
        });

        avance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                listScrollPaneDate.get(0).toFront();
                listLabelTitle.get(0).toFront();
            }
        });

        this.getChildren().addAll(stackPaneTitle,stackPaneMois);
    }
}