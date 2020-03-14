//Student Name:Badal Sarkar
//Student Id:137226189 

//this class provides the structure of the address content
//it contains different elements in the address content

import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.collections.*;

public class AddressContent{
    private String [] provinceList={"ON","BC","AB","SK","MB","NL","NS"};

    //labels
    public Text fName= new Text("First Name:"); 
    public Text lName= new Text("Last Name: "); 
    public Text city= new Text("City:"); 
    public Text province= new Text("Province: ");
    public Text post= new Text("Postal Code"); 

    //textfields 
    public TextField fieldFname= new TextField();
    public TextField fieldLname= new TextField();
    public TextField fieldCity= new TextField();
    public TextField fieldProvince=new TextField();
    public TextField fieldPost= new TextField();

    //specify the length of data
    public int cityLength=20;
    public int lNameLength=20;
    public int postLength=6;
    public int fNameLength=20;
    public int provinceLength=4;
}

