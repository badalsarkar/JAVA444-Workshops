

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


    public boolean used(){
        return this.used;
    }


    public String getPuzzled(){
        return new String(hidden);
    }


    public String getOriginal(){
        return original;
    }


    private void updatePuzzledWord(int index, char c){
        for(int i=0; i<hidden.length; i++){
            if(i==index){
                hidden[i]=original.charAt(i);
            }
        }
    }



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
