//student Name: Badal Sarkar
//Student Id: 137226189

import java.util.Scanner;


//this class provides functionality for 
//various user interaction
class UserInteraction{
    private static Scanner input= new Scanner(System.in);

    //method
    //gets amount from user
    public static double getAmount(String question, double min, double max){
        double amt=0;
        boolean askAgain=false;
        do{
            askAgain=false;
            try{
                System.out.print(question);
                amt=input.nextDouble();
                input.nextLine();
                if(amt<min || amt>max){
                    printError("Invalid entry");
                    askAgain=true;
                }
            }
            catch(Exception e){
                printError("Invalid entry");
            }
        }while(askAgain);
        return amt;
    }



    //overloaded method for getting amount from user
    public static double getAmount(String question, double min){
        double amt=0;
        boolean askAgain=false;
        do{
            askAgain=false;
            try{
                System.out.print(question);
                amt=input.nextDouble();
                input.nextLine();
                if(amt<min){
                    printError("Invalid entry");
                    askAgain=true;
                }
            }
            catch(Exception e){
                printError("Invalid entry");
            }
        }while(askAgain);
        return amt;
    }



    //
    //get a integer input from user
    //
    public static int getNumber(String question, String[] options, int min, int max){
        int result=0;
        boolean askAgain=false;
        int i=1;
        do{
            askAgain=false;
            System.out.print(question);
            if(options!=null){
                System.out.println();
                for(String s:options){
                    System.out.println(i++ +". "+ s);
                }
                System.out.println();
            }

            try{
                result=input.nextInt();
                input.nextLine();
                if(result<min || result > max){
                    printError("Invalid entry");
                    i=1;
                    askAgain=true;
                }
            }
            catch(Exception e){
                System.out.println("Invalid entry");
                i=1;
            }
        }while(askAgain);
        return result;
    }




    //overloaded method for getting integer input from user
    public static int getNumber(String question, String[] options, int min){
        int result=0;
        boolean askAgain=false;
        int i=1;
        do{
            System.out.print(question);
            if(options!=null){
                System.out.println();
                for(String s:options){
                    System.out.println(i++ +"."+ s);
                }
                System.out.println();
            }
            try{
                result=input.nextInt();
                input.nextLine();
                if(result<min){
                    printError("Invalid entry");
                    i=1;
                    askAgain=true;
                }
            }
            catch(Exception e){
                printError("Invalid entry");
                i=1;
                askAgain=true;
            }
        }while(askAgain);
        return result;
    }





    //overloaded method for getting integer input from user
    public static int getNumber(String question){
        int result=0;
        boolean askAgain=false;
        do{
            System.out.print(question);
            try{
                result=input.nextInt();
                input.nextLine();
            }
            catch(Exception e){
                printError("Invalid entry");
                askAgain=true;
            }
        }while(askAgain);
        return result;
    }


    public static String getLine(){
        String result="";
        boolean askAgain=false;
        do{
            try{
                result= input.nextLine();
            }
            catch(Exception e){
                askAgain=true;
            }
        }while(askAgain);
        return result;
    }
    






    //prints error msg
    public static void printError(String msg){
        System.out.println(msg);
        System.out.println("\n");
    }


    //prints custom message with a value
    public static void printMsg(String msg, int value){
        System.out.println(msg+" "+value);
        System.out.println("\n");
    }



    //overloaded method for printing custom message
    public static void printMsg(String msg, double value){
        System.out.println(msg+" "+value);
        System.out.println("\n");
    }


            
}
