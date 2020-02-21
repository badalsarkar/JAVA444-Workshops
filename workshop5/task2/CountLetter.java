//Studen Name: Badal Sarkar
//Student Id: 137226189
//Date: Feb 21, 2020

import java.io.File;
import java.io.FileReader;

public class CountLetter{
    public static void main(String []args){
        File source=null;
        String text="";
        //take the source
        if(args.length>0){
            try{
                source= new File(args[0]);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
           int option= UserInteraction.getNumber("Choose a source from which to count letters-", new String[]{"From file", "From text [to be entered here]"},1,2);
           switch (option){
               case 1:
                   System.out.println("Enter the file name with path i.e. ../../file.txt");
                   System.out.print(">>");
                   source=new File(UserInteraction.getLine());
                   break;
                case 2:
                   System.out.println("Enter the text below. Hit enter when done");
                   System.out.print(">>");
                   text=UserInteraction.getLine();
           }
        }

        if(source!=null){
            LetterCounter.count(source);
        }
        else{
            LetterCounter.count(text);
        }

    }
}
