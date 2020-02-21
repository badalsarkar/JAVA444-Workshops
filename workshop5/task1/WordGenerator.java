//Student Name: Badal Sarkar
//Student Id: 137226189
//Date: Feb 21, 2020

import java.io.*;


/**
 * {@code WordGenerator} class provides the structure and functionality
 * to generate all possible words from the characters written in a phone 
 * dial pad. For example number 2 represents "ABC" in the dial pad
 * this class provides static function to generate words. No object 
 * instantiation is needed
*/

class WordGenerator{
    //the array index represents the actual number in the keypad
    //i.e- array index 2 is the number 2 in the keypad and contains
    //the letters "A, B, C"
    //array index 0 and 1 does not represent any letter therefore empty
    private static char [][] letterMap ={{0}, {0}, {'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},
                                {'M','N','O'},{'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}};
    private static int[] numbers=null;  //stores the number for which words to be generated
    private static String[] allGeneratedWords={""}; //stors all generated words
    private static int count=0;


    //constructor
    public WordGenerator(int[] numbers){
        if(numbers!=null){
            this.numbers=numbers.clone();
        }
    }


    //setter for all generated words
    public void setAllGeneratedWords(String[] list){
        if(list!=null){
            allGeneratedWords=list.clone();
        }
        count=allGeneratedWords.length;
    }


    //return all generated words
    public String[] getAllGeneratedWords(){
        return allGeneratedWords.clone();
    }


    //returns the value of  count
    public int getCount(){
        return count;
    }



    /**generate all possible words and set the 
    *{@code allGeneratedWords}
    */
    public void generateAllWords(){
        for(int i=0; i<numbers.length; i++){
            setAllGeneratedWords(generate(letterMap[numbers[i]]));
        }
    }



    /**
     * generates word combination from the array in parameter
     * and the instance variable allGeneratedWords and updates
     * the allGeneratedWords
     * @param list this is an array of cahr
     * @return String[] an array of string which are as the generated word
    */
    private String[] generate(char[] list){
        int length=list.length*allGeneratedWords.length;

        //create array to store result
        String [] result= new String[length];
        //create words
        for(int i=0; i<allGeneratedWords.length; i++){
            for(int j=0; j<list.length; j++){
                result[length-1]=allGeneratedWords[i]+list[j];
                length--;
            }
        }
        return result;
    }




    //print all generated words to console
    public void print(){
        for(String s: allGeneratedWords){
            System.out.println(s);
        }
        System.out.println("the total word generated is : " +count);
    }

    

}
