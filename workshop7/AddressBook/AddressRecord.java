
//Student Name:Badal Sarkar
//Student Id:137226189 

//this class provides functionality to store, update, read 
//address records in a file
import java.io.RandomAccessFile;

public class AddressRecord{
    private RandomAccessFile file;
    private int lineLength;


    //constructor
    public AddressRecord(String file, int lineLength){
        try{
            this.file= new RandomAccessFile(file, "rw");
            this.lineLength=lineLength;
        }
        catch(Exception e){
        }
    }


    //this function reads the next line
    public String readNextLine(){
        String line="";
        try{
            if(file.getFilePointer()<file.length()){
                line=file.readLine();
            }
        }
        catch(Exception e){

        }
        finally{
            return line;
        }
    }




    //this function reads the previous line
    //from the file
    public String readPreviousLine(){
        String line="";
        try{
            file.seek(file.getFilePointer()-lineLength-lineLength);
        }
        catch(Exception e){
        }
        return readNextLine();
    }




    //this function reads the first line from the file
    public String readFirstLine(){
        try{
            file.seek(0);
        }
        catch(Exception e){
        }
        return readNextLine();
    }





    //this function reads the last line form the file
    public String readLastLine(){
        try{
            file.seek(file.length()-lineLength);
        }
        catch(Exception e){
        }
        return readNextLine();
    }




    //this function writes a line at the end of the file
    public void writeLine(String line){
        if(line!=""){
            try{
                long currentPos=file.getFilePointer();
                file.seek(file.length());
                file.writeBytes(line+"\n");
                file.seek(currentPos);
            }
            catch(Exception e){
            }
        }
        

    }




    //this function updates a record in the file
    public void updateLine(String line){
        try{
            file.seek(file.getFilePointer()-lineLength);
            file.writeBytes(line+"\n");
        }
        catch(Exception e){
        }
    }


    

    //this function closes the file
    public void close(){
        try{
            file.close();
        }
        catch(Exception e){
        }
    }

}
