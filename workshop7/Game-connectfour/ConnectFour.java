//Student Name: Badal Sarkar
//Studne ID: 137226189

import java.util.Arrays;


//this class provides core functionality for the game
public class ConnectFour{
    //instance variable
    private int rowSize;
    private int colSize;

    //this represents the game grid
    private int [][] gameBoard;

    //tells the next emplty row in a column
    //we use this to avoid array traversal 
    private int [] nextRowIndex;


    //methods
    //constructor
    public ConnectFour(int row, int column){
        rowSize=row;
        colSize=column;
        gameBoard=new int[rowSize][colSize];
        nextRowIndex=new int[colSize];
        Arrays.fill(nextRowIndex,(rowSize-1));
    }


    //this function add an entry to a specified column
    public void addToColumn(int column, int value){
        if(nextRowIndex[column-1]>=0){
            gameBoard[nextRowIndex[column-1]][column-1]=value;
            nextRowIndex[column-1]=nextRowIndex[column-1]-1;
        }
    }



    //horizontal count
    //this function counts the total matched cell horizontally
    public int Hcount(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;

        //count right direction
        for(int i=1; i<4; i++){
            if((baseCol+i)<colSize && gameBoard[baseRow][baseCol+i]==matchValue){
                totalMatch++;
            }
            else{
                break;
            }
        }

        //count left direction
        for(int i=1; i<4; i++){
            if((baseCol-i)>=0 && gameBoard[baseRow][baseCol-i]==matchValue){
                totalMatch++;
            }
            else{
                break;
            }
        }

        //now we have total matched horizontally
        return totalMatch;
    }





    //vertical count
    //this function counts the matched cell vertically
    public int Vcount(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;
        //only count downwards
        if(baseRow<rowSize-3){
            for(int i=1; i<4; i++){
                if(gameBoard[baseRow+i][baseCol]==matchValue){
                    totalMatch++;
                }
                else{
                    break;
                }
            }
        }
        return totalMatch;
    }





    //diagonal count
    //upper left diagonal
    //this function counts the matched cell in the upper left diagonal
    public int countUpperLeftDiagonal(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;
        //if we can move up and left
        if(baseRow>0 && baseCol>0){
            for(int i=1; i<4; i++){
                if((baseRow-i>=0 && baseCol-i>=0) && gameBoard[baseRow-i][baseCol-i]==matchValue){
                    totalMatch++;
                }
                else{
                    break;
                }
            }
        }
        return totalMatch;
    }





    //lower right diagonal count
    //this function counts the matched cell in the lower right diagonal
    public int countLowerRightDiagonal(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;
        //if we can move down and right
        if(baseRow<rowSize-1 && baseCol<colSize-1){
            for(int i=1;i<4;i++){
                if((baseRow+i<rowSize && baseCol+i<colSize) && gameBoard[baseRow+i][baseCol+i]==matchValue){
                    totalMatch++;
                }
                else{
                    break;
                }
            }
        }
        return totalMatch;
    }






    //main diagonal
    //this function counts the matched cell in the main diagonal
    private int countMainDiagonal(int baseRow, int baseCol, int matchValue){
        return countUpperLeftDiagonal(baseRow, baseCol, matchValue)+
            countLowerRightDiagonal(baseRow, baseCol, matchValue);
    }







    //upper right diagonal
    //this function counts the total matched cell in the upper right diagonal
    public int countUpperRightDiagonal(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;
        //if we can move up and to the right
        if(baseRow>0 && baseCol<colSize-1){
            for(int i=1; i<4; i++){
                if((baseRow-i>=0 && baseCol+i<colSize) && gameBoard[baseRow-i][baseCol+i]==matchValue){
                    totalMatch++;
                }
                else{
                    break;
                }
            }

        }
        return totalMatch;

    }



    //lower left diagonal
    //this function counts the matched cell in the lower left diagonal
    public int countLowerLeftDiagonal(int baseRow, int baseCol, int matchValue){
        //use this variable to count total match
        int totalMatch=0;
        //if we can move down and left
        if(baseRow<rowSize-1 && baseCol>0){
            for(int i=1;i<4; i++){
                if((baseRow+i<rowSize && baseCol-i>=0) && gameBoard[baseRow+i][baseCol-i]==matchValue){
                    totalMatch++;
                }
                else{
                    break;
                }
            }
        }
        return totalMatch;
    }






    //antidiagonal
    //this funciton counts the matche cell in the antidiagonal
    private int countAntiDiagonal(int baseRow, int baseCol, int matchValue){
        return countUpperRightDiagonal(baseRow, baseCol, matchValue)+
            countLowerLeftDiagonal(baseRow, baseCol, matchValue);
        
    }





    
    //method to determine winning status
    //this function determines the winning status
    public boolean won(int baseCol, int matchValue){
        int baseRow=nextRowIndex[baseCol-1]+1;
        return (
                Hcount(baseRow, (baseCol-1),matchValue)>=3 ||
                Vcount(baseRow, (baseCol-1), matchValue)>=3||
                countMainDiagonal(baseRow, (baseCol-1), matchValue)>=3||
                countAntiDiagonal(baseRow,(baseCol-1),matchValue)>=3
                );

    }


    //get next row index
    //this function return the value of next empty row of a column
    public int getNextRow(int column){
        return nextRowIndex[column-1];
    }




    //this function determines if the game should continue or stop
    public boolean gameContinue(){
        boolean result=false;
        for(int i: nextRowIndex){
            if(i>=0){
                result=true;
                break;
            }
        }
        return result;
    }




    //
    //this funciton prints the grid in the consol
    public void print(){
        for(int i=0; i<rowSize;i++){
            for(int j=0; j<7;j++){
                System.out.print(gameBoard[i][j]+ " ");
            }
            System.out.println();
        }
    }


}
