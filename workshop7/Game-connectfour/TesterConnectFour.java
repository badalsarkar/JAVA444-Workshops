
//Student Name: Badal Sarkar
//Student ID:137226189

public class TesterConnectFour{
    public static void main(String[] args){
        ConnectFour newGame=new ConnectFour(6,7);
        int player=1; 
        boolean gameWon=false;
        //this is the column, the player wants to insert 
        int preferredCol=1;
        int winner=0;

        do{
            System.out.println("Plyer: "+player);
            preferredCol=UserInteraction.getNumber("Choose a column between 1 and 7:> ", null,1,7);
            newGame.addToColumn(preferredCol,player);
            newGame.print();
            //if the game is won
            gameWon=newGame.won(preferredCol,player);
            winner=(gameWon==true)?player:0;
            //flip the player
            player=(player==1?2:1);
        }while(gameWon!=true && newGame.gameContinue());

        System.out.println("Game Over");
        System.out.println("Player "+ winner + " has won the game");
    }
}
