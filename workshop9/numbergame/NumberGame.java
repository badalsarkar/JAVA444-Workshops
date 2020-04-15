
//Student Name: Badal Sarkar
//Student ID:137226189

import java.util.Iterator;
import java.util.HashSet;
import java.util.Vector;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;



/**
 * this class privides the gui interface and all event handlers 
 * this is the main class
**/
public class NumberGame extends Application{
    Numbers myNumbers= new Numbers(0,1000);

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){

        //Hbox 
        HBox contentBottom= new HBox();
        Text textBottom= new Text("Would you like to try with two different numbers?"); 
        Button btnYes= new Button("Yes");
        Button btnExit= new Button("Exit Game");
        contentBottom.getChildren().addAll(textBottom, btnYes, btnExit);
        contentBottom.setSpacing(10.0);


        //GridPane for main content
        GridPane mainContent= new GridPane();
        Button btnGetQuestion= new Button("Generate Question");
        Text heading= new Text();
        Text sumText= new Text();
        Text subsText= new Text();
        Text multiText= new Text();
        Text divText= new Text();
        TextField sumTextField=new TextField();
        TextField subsTextField=new TextField();
        TextField multiTextField= new TextField();
        TextField divTextField= new TextField();
        Text correctAns= new Text("Number of correct answer");
        TextField correctTextField=new TextField();
        Text wrongAns= new Text("Number of wrong answer");
        TextField wrongTextField= new TextField();
        Button btnSubmit= new Button("Submit");
        Text msgText=new Text();

        mainContent.add(btnGetQuestion,1,1);
        mainContent.add(heading,1,2);
        mainContent.add(sumText,1,3);
        mainContent.add(sumTextField, 2,3);
        mainContent.add(subsText,1,4);
        mainContent.add(subsTextField,2,4);
        mainContent.add(multiText,1,5);
        mainContent.add(multiTextField, 2,5);
        mainContent.add(divText,1,6);
        mainContent.add(divTextField,2,6);
        mainContent.add(correctAns, 1,7);
        mainContent.add(correctTextField,2,7);
        mainContent.add(wrongAns, 1,8);
        mainContent.add(wrongTextField,2,8);
        mainContent.add(msgText,1,9);
        mainContent.add(btnSubmit, 1,10);

        

        BorderPane borderPane= new BorderPane();
        borderPane.setBottom(contentBottom);
        borderPane.setCenter(mainContent);

        //eventhandlers
        //shows the generated random numbers
        EventHandler<ActionEvent> showNumbers= new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                //clear previous numbers 
                sumTextField.setText("");
                subsTextField.setText("");
                multiTextField.setText("");
                divTextField.setText("");
                correctTextField.setText("");
                wrongTextField.setText("");

                try{
                    myNumbers.generate();
                    int x=(int)myNumbers.getX();
                    int y=(int)myNumbers.getY();
                    heading.setText("Two randomly generated numbers are "+x + " and "+ y);
                    sumText.setText("What is the addition of "+x + " and " +y);
                    subsText.setText("What is the subtraction of " +x +" and "+y);
                    multiText.setText("What is the multiplication of "+x+" and "+y);
                    divText.setText("What is division of "+ x +" and "+ y);
                }
                catch(Exception ex){
                    System.out.println(ex);
                }

            }

        };



        //event handler 
        //validtes the user answer
        EventHandler<ActionEvent> checkAnswer= new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                //extract user input
                String sumField=sumTextField.getText();
                String subsField=subsTextField.getText();
                String multiField= multiTextField.getText();
                String divField=divTextField.getText();

                //there should not be any empty field
                if(sumField.length()>0 && subsField.length()>0 && multiField.length()>0 && divField.length()>0){
                    Double sum= Double.valueOf(sumField);
                    Double subtraction=Double.valueOf(subsField);
                    Double multiplication= Double.valueOf(multiField);
                    Double div= Double.valueOf(divField);

                    //create a set to store the user answer
                    HashSet<Vector<Double>> myAnswer= new HashSet<Vector<Double>>();
                    Vector<Double> allEntries= new Vector<Double>();
                    allEntries.add(sum);
                    allEntries.add(subtraction);
                    allEntries.add(multiplication);
                    allEntries.add(div);
                    myAnswer.add(allEntries);

                    //invoke calculate method to calculate the correct answers
                    myNumbers.calculate();
                    //invoke validate method to verify user answer 
                    int correctAnswer=myNumbers.validateAnswer(myAnswer);
                    //provide feedback to user 
                    correctTextField.setText(String.valueOf(correctAnswer));
                    wrongTextField.setText(String.valueOf(4-correctAnswer));
                }
                else{

                    msgText.setText("Please write all answers");
                    msgText.setFill(Color.RED);
                }
            }
        };





        //attach event handlers to buttons
        btnGetQuestion.setOnAction(showNumbers);
        btnSubmit.setOnAction(checkAnswer);
        btnYes.setOnAction(showNumbers);
        btnExit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                System.exit(0);
            }
        });

        Scene myScene= new Scene(borderPane, 600,300);
        stage.setScene(myScene);
        stage.setTitle("Number Game");
        stage.show();

    }

}
