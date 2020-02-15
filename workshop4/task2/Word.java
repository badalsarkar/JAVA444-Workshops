//Student name: Badal Sarkar
//Student id: 137226189



//this class provides structure to store a word
//the class provides functionality to hide the word, 
//match a letter with the original word
//also tells if the hidden word is fully matched or not
class Word{
    private String original="";
    private char[] hidden;
    private boolean used=false;
    private boolean fullMatch=false;

    //methods
    public Word(String word){
        if(word!=""){
            original=word;
            updatePuzzledWord('*');
        }
    }

    //use word
    public void use(){
        used=true;
    }


    //returns if the word has been already used
    public boolean used(){
        return this.used;
    }


    //returns the word in hidden form
    public String getPuzzled(){
        return new String(hidden);
    }


    //returns the original word
    public String getOriginal(){
        return original;
    }



    //this function updates the hidden word
    //by replacing the * with the original letter at the index
    private void updatePuzzledWord(int index, char c){
        for(int i=0; i<hidden.length; i++){
            if(i==index){
                hidden[i]=original.charAt(i);
            }
        }
    }



    //this function updates the hidden word
    //it replaces the original word with the parameter
    private void updatePuzzledWord(char c){
        hidden=new char[original.length()];
        for(int i=0; i<hidden.length; i++){
            hidden[i]=c;
        }
    }


    //print word
    public void printOriginal(){
        System.out.println(original);
    }



    public void printPuzzled(){
        for(char c: hidden){
            System.out.print(c);
        }
        System.out.println();
    }


    //match a letter to the original word
    //if matched, it updates the hidden word 
    //to reflect the matched letter
    public boolean match(char c){
        int index=-1;
        int startPos=0; 
        boolean result=false;;
        do{
            index=original.indexOf(c, startPos);
            if(index!=-1){
                updatePuzzledWord(index, '*');
                startPos=index+1;
                result=true;
            }
        }while(index!=-1);
        return result;
    }





    //this function checks if the hidden word 
    //is fully matched
    public boolean fullMatched(){
        boolean result=true;
        for(char c: hidden){
            if(c=='*'){
                result=false;
                break;
            }
        }
        return result;
    }


}
