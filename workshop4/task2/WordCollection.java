//Student name: Badal Sarkar
//Student id: 137226189
//
//
//this class provides structure to store all the words
//randomly display a word

class WordCollection{
    private Word [] allWords;

    //methods
    //constructor
    public WordCollection(String [] collection){
        if(collection!=null){
            allWords=new Word[collection.length];
            for(int i=0; i<allWords.length; i++){
                allWords[i]=new Word(collection[i]);
            }
        }

    }





    //this function randomly selects a word from the 
    //array, and returns it.
    public Word getWord(){
        boolean loop=false;
        Word result=null;
        if(thereIsUnusedWord()){
            do{
                int index=(int)(Math.random()*allWords.length);
                if(allWords[index].used()){
                    loop=true;
                }
                else{
                    result=allWords[index];
                    loop=false;
                }
            }while(loop);
        }
        return result;
    }







    //displays next word
    public void displayNextWord(){
        Word w=getWord();
        if(w!=null){
            w.printOriginal();
        }
        else{
            System.out.println("All words have been used");
        }
    }





    //this function checks if there is unused word in the array
    //
    private boolean thereIsUnusedWord(){
        boolean result=false;
        for(Word w: allWords){
            if(!w.used()){
                result= true;
                break;
            }
        }
        return result;
    }


}
