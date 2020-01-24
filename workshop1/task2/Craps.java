//Craps game
//Game rule
//roll two dice
//generate random value between 1-6 in each dice
//sum the two value
//sum in (2,3,12) you lose
//sum in (7, 11) you win
//sum in (4,5,6,8,9 10) store in point
//loop untill sum is 7 or same as stored point
//if 7 you lose
//if same as stored value you win


class Craps{
    public static void main(String [] args){
        int dice1, dice2,sum,point;
        //generate random number
        dice1=((int)(Math.random()*6))+1;
        dice2=((int)(Math.random()*6))+1;
        sum=dice1+dice2;
        if(sum==2||sum==3||sum==12){
            System.out.println("You rolled " + dice1 +"+"+dice2+"="+sum);
            System.out.println("Better Luck Next Time, You Lose.");
        }
        else if(sum==7 || sum==11){
            System.out.println("You rolled " + dice1 +"+"+dice2+"="+sum);
            System.out.println("Congratulations, You Win");
        }
        else{
            point=sum;
            System.out.println("You rolled " + dice1 +"+"+dice2+"="+sum);
            System.out.println("Point is set to "+point);
            boolean keepRolling;
            //continue loop untill the sum is 7 or equal to point
            do{
                //resetting sum
                sum=0;
                dice1=((int)(Math.random()*6))+1;
                dice2=((int)(Math.random()*6))+1;
                sum=dice1+dice2;
                System.out.println("You rolled " + dice1 +"+"+dice2+"="+sum);
                if(sum==7){
                    System.out.println("Better Luck Next Time, You Lose.");
                    keepRolling=false;
                }
                else if(sum==point){
                    System.out.println("Congratulations, You Win");
                    keepRolling=false;
                }
                else{
                    keepRolling=true;
                }
            }while(keepRolling);
        }
    }
};



                
