
//Student Name: Badal Sarkar
//Student ID:137226189

//this class provides event handlers for buttons

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.collections.ObservableList;

public class ButtonEvents {
    TextField yearField;
    TextField genderField;
    TextField nameField;
    TextField rankingField;


    public ButtonEvents(GridPane fields){
        ObservableList<Node> allFields= fields.getChildren();
        yearField=(TextField)allFields.get(1);
        genderField=(TextField)allFields.get(3);
        nameField=(TextField)allFields.get(5);
        rankingField=(TextField)allFields.get(7);
    }



    //event handler for submit button
    public EventHandler<ActionEvent> submit(){
        EventHandler<ActionEvent> submitBtnHandler= new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                String year=((yearField.getText()).trim()).toLowerCase();
                String gender=((genderField.getText()).trim()).toLowerCase();
                String name=((nameField.getText()).trim()).toLowerCase();
                boolean male=false;
                if((gender.toLowerCase()).trim().matches("male")){
                    male=true;
                    int result=BabyNameRanking.getRanking(year,male,name);
                    if(result!=-1){
                        rankingField.setText(Integer.toString(result));
                    }
                    else{
                        rankingField.setText("No record");
                    }

                }
                else if((gender.toLowerCase()).trim().matches("female")){
                    male=false;
                    int result=BabyNameRanking.getRanking(year,male,name);
                    if(result!=-1){
                        rankingField.setText(Integer.toString(result));
                    }
                    else{
                        rankingField.setText("No record");
                    }
                }
                else{
                    Alert error=new Alert(AlertType.ERROR, "Invalid Gender Selection");
                    error.show();
                    yearField.setText("");
                    genderField.setText("");
                    nameField.setText("");
                    rankingField.setText("");
                }

            }
            
        };

        return submitBtnHandler;
    }






    //event handler for exit button
    public EventHandler<ActionEvent> exit(){
        return (new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.exit(0);
            }

        });

    }





    //event handler for another query button
    public EventHandler<ActionEvent> anotherQuery(){
        return (new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                yearField.setText("");
                genderField.setText("");
                nameField.setText("");
                rankingField.setText("");
            }

        });
    }

}
