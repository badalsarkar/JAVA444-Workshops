//Student name: Badal Sarkar
//Student ID; 137226189


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableList;


public class AddressBook extends Application{
    public static void main(String [] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){
        //creating labels
        Text firstName= new Text("First Name");
        Text lastName= new Text("Last Name");
        Text city= new Text("City");
        Text province= new Text("Province");
        Text postCode= new Text("Postal Code");


        //creating text fields
        TextField fnField= new TextField();
        TextField lnField= new TextField();
        TextField ctField= new TextField();
        TextField pvnField= new TextField();
        TextField postField= new TextField();


        //creating buttons
        //
        Button addBtn= new Button("Add");
        Button firstBtn= new Button("First");
        Button nextBtn= new Button("Next");
        Button previousBtn= new Button("Previous");
        Button lastBtn=new Button("Last");
        Button updateBtn=new Button("Update");
        
        //instantiate a grid
        GridPane grid=new GridPane();
        grid.setMinSize(320,320);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);


        grid.add(firstName, 0,0);
        grid.add(fnField, 1,0);

        grid.add(lastName, 0,1);
        grid.add(lnField, 1,1);

        grid.add(city, 0,2);
        grid.add(ctField, 1,2);

        grid.add(province, 2,2);
        grid.add(pvnField, 3,2);

        grid.add(postCode, 4,2);
        grid.add(postField, 5,2);


        //creating flow pane
        FlowPane flowPane= new FlowPane();
        flowPane.setHgap(25);
        flowPane.getChildren().addAll(addBtn,firstBtn, nextBtn, previousBtn, lastBtn, updateBtn);
        grid.add(flowPane,0,4);


        Scene scene= new Scene(grid);
        stage.setTitle("Address Book");
        stage.setScene(scene);
        stage.show();
    }

}

