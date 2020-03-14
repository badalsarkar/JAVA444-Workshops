//Student Name:Badal Sarkar
//Student Id:137226189 
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import java.util.List;

//this is the main class
//
public class AddressBook extends Application{
    //instance variable
    AddressContent addrItems= new AddressContent();
    AddressRecord addressData=new AddressRecord("addressdata.txt", 71);

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){

        //use HBox to add city, province and postal
        HBox address= new HBox();
        address.setPadding(new Insets(10,10,10,10));
        address.setSpacing(10);
        address.getChildren().addAll(addrItems.city, addrItems.fieldCity, addrItems.province, addrItems.fieldProvince, 
                addrItems.post, addrItems.fieldPost);


        //use gridpane to arrange the fields
        GridPane content= new GridPane();
        content.setHgap(10);
        content.setVgap(10);
        content.setPadding(new Insets(0,10,0,10));

        //add elements to the gridpane
        content.add(addrItems.fName, 0,0);
        content.add(addrItems.fieldFname,1,0,4,1);
        content.add(addrItems.lName, 0,1);
        content.add(addrItems.fieldLname, 1,1,4,1);
        content.add(address,0,2,4,1);


        
        //add a border pane 
        BorderPane borderPane=new BorderPane();
        HBox lowerSection= addAllButtons();
        borderPane.setBottom(lowerSection);
        borderPane.setCenter(content);


        //create scene
        Scene scene= new Scene(borderPane, 600,200);
        stage.setScene(scene);
        stage.setTitle("Address Book");
        stage.setResizable(false);
        stage.show();
    }




    //this method is used to create the lower
    //section of the address box
    //the lower section contains some buttons
    private HBox addAllButtons(){
        HBox hbox= new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);

        //creating buttons
        Button buttonAdd= new Button("Add");
        buttonAdd.setPrefSize(100,20);
        Button buttonFirst= new Button("First");
        buttonFirst.setPrefSize(100,20);
        Button buttonNext= new Button("Next");
        buttonNext.setPrefSize(100,20);
        Button buttonPrevious= new Button("Previous");
        buttonPrevious.setPrefSize(100,20);
        Button buttonLast= new Button("Last");
        buttonLast.setPrefSize(100,20);
        Button buttonUpdate= new Button("Update");
        buttonUpdate.setPrefSize(100,20);

        hbox.getChildren().addAll(buttonAdd, buttonFirst, buttonNext, buttonPrevious, buttonLast, buttonUpdate);

        //adding event handler
        buttonAdd.setOnAction(new ButtonHandler(addrItems,addressData, "add"));
        buttonFirst.setOnAction(new ButtonHandler(addrItems,addressData, "first"));
        buttonNext.setOnAction(new ButtonHandler(addrItems,addressData, "next"));
        buttonPrevious.setOnAction(new ButtonHandler(addrItems,addressData, "previous"));
        buttonLast.setOnAction(new ButtonHandler(addrItems,addressData, "last"));
        buttonUpdate.setOnAction(new ButtonHandler(addrItems,addressData, "update"));

        return hbox;
    }



}
