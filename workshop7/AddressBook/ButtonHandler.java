//Student Name:Badal Sarkar
//Student Id:137226189 
//
//this class provides event handlers for all buttons

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import java.lang.Runnable;


public class ButtonHandler implements EventHandler<ActionEvent>{

    AddressContent elements;
    //stores the value of each text field
    String[] elementValue=new String[5];
    //stores the length of each field
    int[]elementLength=new int[5];
    //this is the object for writing to file
    AddressRecord run;
    String btnName="";


    //constructor
    public ButtonHandler(AddressContent c, AddressRecord r, String btnName){
        elements=c;
        run=r;
        this.btnName=btnName;
        elementLength[0]=elements.fNameLength;
        elementLength[1]=elements.lNameLength;
        elementLength[2]=elements.cityLength;
        elementLength[3]=elements.provinceLength;
        elementLength[4]=elements.postLength;
    }


    //button handler for each button
    //appropriate handler is called based on 
    //button name
    @Override
    public void handle(ActionEvent e){
        //writeEvent();
        if(btnName=="add"){
            run.writeLine(getFieldInfo());
        }
        else if(btnName=="first"){
            String line=run.readFirstLine();
            updateFields(line);
        }
        else if(btnName=="next"){
            String line=run.readNextLine();
            if(line!=""){
                updateFields(line);
            }
        }
        else if(btnName=="previous"){
            String line=run.readPreviousLine();
            updateFields(line);
        }
        else if(btnName=="last"){
            String line=run.readLastLine();
            updateFields(line);
        }
        else if(btnName=="update"){
            run.updateLine(getFieldInfo());

        }


    }



    //this function extracts the textfield value
    //modify the value as per length of each item
    //and stores in the array
    private String getFieldInfo(){
        elementValue[0]=elements.fieldFname.getText();
        elementValue[1]=elements.fieldLname.getText();
        elementValue[2]=elements.fieldCity.getText();
        elementValue[3]=elements.fieldProvince.getText();
        elementValue[4]=elements.fieldPost.getText();

        //make the fields empty
        elements.fieldFname.setText("");
        elements.fieldLname.setText("");
        elements.fieldCity.setText("");
        elements.fieldProvince.setText("");
        elements.fieldPost.setText("");

        String line="";
        for(int i=0;i<5;i++){
            if(elementLength[i]<elementValue[i].length()){
                line+=(elementValue[i].substring(0,elementLength[i]));
            }
            else{
                int gap=elementLength[i]-elementValue[i].length();
                line+=elementValue[i];
                for(int j=0; j<gap;j++){
                    line+=" ";
                }
            }
        }
        return line;

    }




    //this function takes a line as parameter
    //split the line and displays items in the 
    //appropriate box in the stage
    private void updateFields(String line){
        int startpos=0;
        int endpos=0;

        //first name
        endpos=elements.fNameLength-1;
        elements.fieldFname.setText((line.substring(startpos,endpos)).trim());
        startpos=endpos+1;
        endpos=endpos+elements.lNameLength;

        //last name
        elements.fieldLname.setText((line.substring(startpos,endpos)).trim());
        startpos=endpos+1;
        endpos=endpos+elements.cityLength;

        //city
        elements.fieldCity.setText(line.substring(startpos, endpos).trim());
        startpos=endpos+1;
        endpos=endpos+elements.provinceLength;

        elements.fieldProvince.setText(line.substring(startpos, endpos).trim());
        startpos=endpos+1;
        endpos=endpos+elements.postLength;

        elements.fieldPost.setText(line.substring(startpos, endpos).trim());

    }




}

