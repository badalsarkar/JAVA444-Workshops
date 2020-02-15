//Student name: Badal Sarkar
//Student id: 137226189
//
//
//main program

public class HangMan{
    private static String [] words={"Programming", "Java", "Object", "Reference", "Internet", "Variable"};
    private static char[] missedLetter;
    private static char[] correctLetter;
    private static WordCollection wordCollection= new WordCollection(words);

    public static void main(String[] args){
        char playAgain='\0';
        int missedAttempt=0;
        do{
            missedLetter=null;
            //get a random word
            Word hiddenWord= wordCollection.getWord();
            hiddenWord.use();
            do{
                //show the word as hidden
                UserInteraction.printMsg("(Guess) Enter a letter in word", hiddenWord.getPuzzled());
                //get user response
                char response=UserInteraction.getChar();
                //if the response is already tried
                if(alreadyTried(response)){
                    UserInteraction.printError("You have already tried", response);
                    UserInteraction.printMsg("Try another word");
                }
                //if the response already in the word
                else if(alreadyCorrect(response)){
                    System.out.print(response);
                    UserInteraction.printError(" is already in the word");
                }
                //otherwise check if the response is correct
                //and display appropriate message
                else{
                    if(hiddenWord.match(response)){
                        addToCorrectLetter(response);
                    }
                    else{
                        addToTriedLetter(response);
                        missedAttempt++;
                        System.out.print(response);
                        UserInteraction.printError(" is not in the word");
                    }
                }
            }while(!hiddenWord.fullMatched());
            //print the game summary
            UserInteraction.printMsg("The correct word is", hiddenWord.getOriginal());
            UserInteraction.printMsg("You missed", missedAttempt);
            UserInteraction.printMsg("Do you want to play with another word? y/n");
            playAgain=UserInteraction.getChar();
        }while(playAgain=='y'||playAgain=='Y');
    }
// end of main


    //this function checks if the parameter 
    //exists in the missedLetter array
    //this function is used to check if a letter 
    //is already tried by player
    private static boolean alreadyTried(char letter){
        boolean result=false;
        if(missedLetter!=null){
            for (char c: missedLetter){
                if(c==letter){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }




    //this function add the parameter to the missedLetter array
    private static void addToTriedLetter(char c){
        if(missedLetter==null){
            missedLetter= new char[1];
            missedLetter[0]=c;
        }
        else{
            char[] temp= new char [missedLetter.length+1];
            System.arraycopy(missedLetter, 0, temp, 0, missedLetter.length);
            temp[temp.length-1]=c;
            missedLetter=temp;
        }
    }





    //this function checks if the parameter exists in 
    //the correctLetter array
    //this function is used to check if a letter is 
    //already present in the word
    private static boolean alreadyCorrect(char letter){
        boolean result=false;
        if(correctLetter!=null){
            for (char c: correctLetter){
                if(c==letter){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }




    //this function add the parameter to the correctLetter array
    private static void addToCorrectLetter(char c){
        if(correctLetter==null){
            correctLetter=new char [1];
            correctLetter[0]=c;
        }
        else{
            char[] temp=new char[correctLetter.length+1];
            System.arraycopy(correctLetter, 0,temp,0, correctLetter.length);
            temp[temp.length-1]=c;
            correctLetter=temp;
        }
    }


}
