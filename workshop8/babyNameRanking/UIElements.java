
//Student Name: Badal Sarkar
//Student ID:137226189


import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;



/**
 * this is a utility class for various type of UI element
**/


public class UIElements{
    private static int buttonSpacing=10;




    /**
     * sets the value of buttonSpacing
     * @param   value   the value for button spacing
    **/
    public static void setButtonSpacing(int value){
        if(value>0){
            buttonSpacing=value;
        }
    }







    /**
     * generates an HBox with each element from an array
     * each HBox element is a button
     * @param   text    an array of buttons names
     * @return  HBox    HBox of buttons generated
    **/
    public static HBox getHButtons(String[] text){
        HBox buttons=new HBox();
        buttons.setPadding(new Insets(10,10,10,10));
        buttons.setSpacing(buttonSpacing);
        

        for(int i=0;i<text.length; i++){
            buttons.getChildren().add(new Button(text[i]));
        }
        return buttons;
    }




    



    /**
     * generates a gridpane- with a text and text field for each
     * element in the array
     * @param   fieldName   an array of field name
     * @return              GridPane of Text and TextFields
    **/
    public static GridPane getInputFields(String[] fieldName){
        GridPane fields= new GridPane();
        fields.setPadding(new Insets(10,10,10,10));
        fields.setHgap(10);
        fields.setVgap(10);

        int row=0;
        int col=0;

        for(int i=0;i<fieldName.length; i++){
            fields.add(new Text(fieldName[i]),col,row);
            fields.add(new TextField(),(col+1),row);
            row++;
        }
        return fields;

    }





}
