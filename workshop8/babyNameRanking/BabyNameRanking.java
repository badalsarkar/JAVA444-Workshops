
//Student Name: Badal Sarkar
//Student ID:137226189

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;
import java.util.Arrays;

/**
 * BabyNameRanking class encapsulates baby name ranking functionality
 * The class holds the dataset of baby name ranking for several years
 * Users can query the ranking of a name (male/female), for a specific year
**/


public class BabyNameRanking{
    private static String fileName="files/babynamesranking";
    private static String fileFormat=".txt";

    /**
    * returns the ranking of a name
    * @param    year    the year for which the ranking is to be searched for
    * @param    male    true if the name is male, false if female 
    * @param    name    the actual name to be searched for
    * @return           an int representing the ranking 
    **/

    public static int getRanking(String year, boolean male, String name){
        if(year.matches("200[1-9]")==false){
            return -1;
        }
        //construct filepath 
        String filePath=fileName + year + fileFormat;
        Scanner file=null;
        int lineNumber=0;
        boolean nameFound=false;

        try{
            file=new Scanner(new File(filePath));
            while(file.hasNextLine()){
                lineNumber++;
                nameFound=(file.nextLine()).matches(getPattern(male,name));
                if(nameFound){
                    return lineNumber;
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("File name is blank");
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
        catch(Exception e){
            System.out.println("An error occured" + e);
        }
        finally{
            file.close();
        }
        return -1;
    }





    /**
     * this methods construct regex pattern based on gender
     * this class is using two regex pattern- one for male and 
     * another for female
     * @param   male    true if male pattern to be generated, false for female
     * @return          a regex pattern
     *
    **/
    private static String getPattern(boolean male, String name){
        if(male){
            return "(?i:^\\d+\\s+" +name+ "\\s+.+)";
        }
        else{
            return "(?i:^\\d+\\s+\\w+\\s+.+"+name+"\\s+.+)";
        }

    }


}
