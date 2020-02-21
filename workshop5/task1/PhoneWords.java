//Student Name: Badal Sarkar
//Student Id: 137226189
//Date: Feb 21, 2020


import java.util.concurrent.TimeUnit;
import java.io.*;


/**
 * {@code PhoneWords} class runs a program that ask user
 * for phone number and then generate all possible words
 * with the characters represented by each digit. In phone 
 * dial pad each digit represents a set of characters
 * you can configure this class to accept as many digits as you want
 * the default value is 7 stored at {@code maxLength}
 * If you want to exclude any number include those in the 
 * {@code excluded} array
*/

public class PhoneWords{
    private static int maxLength=7;
    private static int[] excluded={0,1};

    //main method
    public static void main(String[] args){
        int []numbers=null;
        //get the phone number
        numbers=getPhoneNumber();
        WordGenerator w=new WordGenerator(numbers);
        //generate all possible words
        w.generateAllWords();
        //write to file
        try{
            //ask for file name
            System.out.println("Enter a file name. A new file will be created");
            String fileName= UserInteraction.getLine();
            PrintWriter fileOut= new PrintWriter(new FileWriter(fileName));
            fileOut.println("The total number of word generated is: "+w.getCount());
            for(String s: w.getAllGeneratedWords()){
                fileOut.println(s);
            }
            fileOut.close();
            System.out.println("All the generated words have been saved at "+fileName);
        }
        catch(Exception e){
            System.out.println("An error occured. Re-run the program");
            System.out.println(e);
        }

    }//end of main






    /**
     * Extract phone number from console. The method excludes
     * any number in the {@code excluded} array and accepts
     * only {@code maxLength} numbers
     * @param none
     * @return an int array with numbers
    */
    private static int[] getPhoneNumber(){
        int[] numbers= new int[maxLength];
        boolean askAgain=false;
        do{
            System.out.print("Enter the phone number: ");
            //extract user input
            String line= UserInteraction.getLine();
            try{
                //check maxLength condition
                if(line.length()<maxLength || line.length()>maxLength){
                    System.out.println("The number must be of 7 digits");
                    askAgain=true;
                }
                else{
                    //extract each digit and convert to int
                    for(int i=0; i<maxLength;i++){
                        numbers[i]=Integer.parseInt(String.valueOf(line.charAt(i)));
                        //check if digit is excluded
                        if(numberIsExcluded(numbers[i])){
                            System.out.println("The digit " + numbers[i] +" is not valid");
                            askAgain=true;
                            break;
                        }
                        else{
                            askAgain=false;
                        }
                    }
                }
            }
            //in exception ask user to input again
            catch(Exception e){
                askAgain=true;
                System.out.println(e);
                System.out.println("Only enter numeric value of 7 digits");
            }
        }while(askAgain);
        return numbers;
    }





    /**
     * checks if the number is excluded
     * @param number an int, this will be checked
     * agains excluded numbers
     * @return boolean
    */
    private static boolean numberIsExcluded(int number){
        boolean result=false;
        for(int num: excluded){
            if(num==number){
                result=true;
                break;
            }
        }
        return result;
    }



}

