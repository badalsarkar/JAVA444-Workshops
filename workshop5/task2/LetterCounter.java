//Studen Name: Badal Sarkar
//Student Id: 137226189
//Date: Feb 21, 2020


import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;



/**
 * A {@code LetterCounter} object counts the occurance of a letter
 * in the given source. The object can be instantiated suppling 
 * a string or a file as a source. The object uses ASCII table value
 * as the array index to store the count of a letter
*/
class LetterCounter{
    /**
     * The {@code letterCounts} array index represents letters from ASCII table
     * i.e. index 65 represents 'A', index 48 represents '0'
    */
    private static int[] letterCounts=new int[128]; //holds the count info for each letter in ASCII Table
    private static String source;   //stores the source from which to count the letters
    private static String [] userOptions={"Count character only", "count numeric only","Count special character only","Count character and numeric", 
                                    "Count all"}; //the class can count using these options
    private static boolean caseSensitive=true;  //if the character count is case sensitive


    /**
     * Constructor
     * @params text represents the string from which the letters to 
     * be counted
    */
    public LetterCounter(String s){
        if(!s.isEmpty()){
            this.source=s;
        }
    }




    /**
     * Increases the value of letterCounts[index] by 1
     * @param index is the index of letterCounts which is to be increased
     * @return nothing
    */
    private static void increaseLetterCounts(int index){
        if(index>=0){
            letterCounts[index]++;
        }
    }





    /**
     * counts the letters from a file
     * and prints the result in the console
     * @param fileName a File object that stores the letters to be countd
     * @return nothing
    */
    public static void count(File fileName){
        String text= createStringFromFile(fileName);
        int option=UserInteraction.getNumber("What do you want to count?",userOptions, 1, userOptions.length);
        switch (option){
            case 1:
                countCharOnly(text);
                break;
            case 2:
                countNumericOnly(text);
                break;
            case 3:
                countSpecialCharOnly(text);
                break;
            case 4:
                countCharNumeric(text);
                break;
            case 5:
                countAll(text);
        }
        print();
    }





    /**
     *creates a string from the contents of the file
     *@param fileName a file object
     *@return String
    */
    private static String createStringFromFile(File fileName){
        String l="";
        try{
            BufferedReader file=new BufferedReader(new FileReader(fileName));
            String temp="";
            while((temp=file.readLine())!=null){
                l+=temp;
                l+=" ";
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return l;
    }








    /**
     * counts the letters from a given string
     * and displays the result in the console
     * @param text a String 
     * @return nothing
    */
    public static void count(String text){
        int option=UserInteraction.getNumber("What do you want to count?",userOptions, 1, userOptions.length);
        switch (option){
            case 1:
                countCharOnly(text);
                break;
            case 2:
                countNumericOnly(text);
                break;
            case 3:
                countSpecialCharOnly(text);
                break;
            case 4:
                countCharNumeric(text);
                break;
            case 5:
                countAll(text);
        }
        print();
    }





    /**counts the alpha only from the string and
     * updates the letterCount array
     * @param text an String from which the letters to be counted
     * @return nothing
    */
    private static void countCharOnly(String text){
        int caseOption=UserInteraction.getNumber("Select one from below:", new String[]{"Case sensitive", "Case insensitive"}, 1, 2);
        if(caseOption==1){
            caseSensitive=true;
        }
        else{
            caseSensitive=false;
        }
        char[] textarray= text.toCharArray();
        if(caseSensitive){
            for(char c: textarray){
                if(AsciiInfo.isAlpha(c)){
                    increaseLetterCounts((int)c);
                }
            }
        }
        else{
            for(char c: textarray){
                if(AsciiInfo.isAlpha(c)){
                    increaseLetterCounts((int)Character.toUpperCase(c));
                }
            }
        }
    }






    
    /**counts the numeric letters only from the string and
     * updates the letterCount array
     * @param text an String from which the letters to be counted
     * @return nothing
    */
    private static void countNumericOnly(String text){
        char[] textarray= text.toCharArray();
        for(char c: textarray){
            if(AsciiInfo.isNumeric(c)){
                increaseLetterCounts((int)c);
            }
        }
    }






    /**counts the special char only from the string and
     * updates the letterCount array
     * @param text an String from which the letters to be counted
     * @return nothing
    */
    private static void countSpecialCharOnly(String text){
        char[] textarray= text.toCharArray();
        for(char c: textarray){
            if(AsciiInfo.isSpecialChar(c)){
                increaseLetterCounts((int)c);
            }
        }
    }






    /**counts the  char and numeric letters only from the string and
     * updates the letterCount array
     * @param text an String from which the letters to be counted
     * @return nothing
    */
    private static void countCharNumeric(String text){
        char[] textarray= text.toCharArray();
        for(char c: textarray){
            if(AsciiInfo.isAlpha(c)|| AsciiInfo.isNumeric(c)){
                increaseLetterCounts((int)c);
            }
        }
    }





    /**counts all letters only from the string and
     * updates the letterCount array
     * @param text an String from which the letters to be counted
     * @return nothing
    */
    private static void countAll(String text){
        char [] textarray= text.toCharArray();
        for(char c: textarray){
            increaseLetterCounts((int)c);
        }
    }





    /** prints the counted numbers
    */
    public static void print(){
        for(int i=0; i<letterCounts.length; i++){
            if(letterCounts[i]>0){
                System.out.println("Number of " + (char)i+ "'s : "+ letterCounts[i]);
        }
    }
}


}//end of class


