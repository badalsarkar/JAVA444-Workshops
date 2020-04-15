
//Student Name: Badal Sarkar
//Student ID:137226189

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

/**
 * This class provides UI for the Name Ranking application
**/

public class NameRanking extends Application{
    //variables
    private String [] allButtons={"Submit Query", "Exit", "New Query"};
    private String [] allFields={"Enter the Year","Enter the Gender", "Enter the Name", "The Ranking is "};



    public static void main(String[] args){
        //BabyNameRanking.getRanking("2009",true,"robert");
        launch(args);

    }


    @Override
    public void start(Stage initialStage){
        //create grid pane for fields
        GridPane fields=UIElements.getInputFields(allFields);
        //create hbox for buttons
        HBox buttons=UIElements.getHButtons(allButtons);
        //attach event handler for each button
        ButtonEvents allEvents=new ButtonEvents(fields);
        ((Button)((buttons.getChildren()).get(0))).setOnAction(allEvents.submit());
        ((Button)((buttons.getChildren()).get(1))).setOnAction(allEvents.exit());
        ((Button)((buttons.getChildren()).get(2))).setOnAction(allEvents.anotherQuery());

        //border pane organizes all fields
        BorderPane borderPane= new BorderPane();
        borderPane.setBottom(buttons);
        borderPane.setCenter(fields);



        //create scene
        Scene myScene=new Scene(borderPane, 300,200);
        initialStage.setScene(myScene);
        initialStage.setTitle("Baby Name Ranking");
        initialStage.show();

    }
}
