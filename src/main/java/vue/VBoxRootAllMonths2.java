package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRootAllMonths2 extends VBox implements ConstantesCalendrier {
    public VBoxRootAllMonths2() {

        VBox contenu = new VBox(50);

        StackPane stackPaneMois = new StackPane();
        DateCalendrier ajd = new DateCalendrier();

        StackPane stackPaneTitle = new StackPane();
        stackPaneTitle.setId("test");

        HBox top = new HBox(5);

        Button beggining = new Button("<<");
        Button recul = new Button("<");

        Button end = new Button(">>");
        Button avance = new Button(">");

        HBox bouton = new HBox(2);
        bouton.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(bouton, Priority.ALWAYS);
        bouton.getChildren().addAll(beggining,recul,avance,end);

        top.getChildren().addAll(stackPaneTitle,bouton);
        top.setAlignment(Pos.CENTER);
        //this.getChildren().add(top);


        for (int i = 1; i <= 12; i++)
        {
            //VBox contenu = new VBox();
            //contenu.setId("test");

            CalendrierDuMois monthCalendar = new CalendrierDuMois(i,2022);
            Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
            labelTitle.setId("titre");
            labelTitle.setMinHeight(30);
            labelTitle.setMinWidth(200);
            labelTitle.setPadding(new Insets(8,8,8,8));
            labelTitle.setAlignment(Pos.CENTER_LEFT);

            VBox.setMargin(labelTitle, new Insets(14));
            VBox boiteDates = new VBox();

            TilePane tilePaneDates = new TilePane();
            tilePaneDates.setPrefColumns(7);
            tilePaneDates.setVgap(18);
            tilePaneDates.setId("calendrier");

            for (String jour : JOURS_SEMAINE){
                Label tempLabel = new Label(jour);
                tempLabel.setId("jours");
                tilePaneDates.getChildren().add(tempLabel);
            }
            for (DateCalendrier date : monthCalendar.getDates()){
                Label tempLabel = new Label(date.getJour()+ "");
                tempLabel.setMinSize(35,25);
                tempLabel.setAlignment(Pos.CENTER);
                if (date.getMois() != monthCalendar.getMois()){
                    tempLabel.setId("HorsMois");
                }
                if (ajd.compareTo(date) == 0) {
                    tempLabel.setId("today");
                }
                tilePaneDates.getChildren().add(tempLabel);
            }
            tilePaneDates.setAccessibleText(MOIS[i-1]);
            stackPaneMois.getChildren().addAll(tilePaneDates);
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

        beggining.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                while(! listScrollPaneDate.get(lastIndice).getAccessibleText().equals("janvier")){
                    listScrollPaneDate.get(lastIndice).toBack();
                    listLabelTitle.get(lastIndice).toBack();
                }
            }
        });

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

        end.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                while(! listScrollPaneDate.get(lastIndice).getAccessibleText().equals("décembre")){
                    listScrollPaneDate.get(0).toFront();
                    listLabelTitle.get(0).toFront();
                }
            }
        });
        contenu.getChildren().addAll(top,stackPaneMois);
        this.getChildren().addAll(contenu);
    }
}