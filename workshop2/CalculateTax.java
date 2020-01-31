//Student Name: Badal Sarkar
//Student ID:137226189

import java.util.Scanner;


public class CalculateTax{
    //static variable
    private static final String[] programMenu={"1. Compute Personal Income Tax",
        "2. Print the tax tables for taxable incomes (with range)", 
        "3. Exit"};



    //main
    public static void main(String[] args){
        int userSelection=0;
        displayWelcomeScreen();
        do{
            displayProgramMenu();
            userSelection=getUserSelection();
            switch (userSelection){
                case 1:
                    int taxYear=getTaxYear();
                    int filingStatus= getFilingStatus();
                    double taxableAmount=getTaxableAmount("Enter the taxable amount: ");
                    double tax=calculateTax(taxYear, filingStatus, taxableAmount);
                    System.out.println("the tax is :" +tax);
                    System.out.println();
                    break;
                case 2:
                    printTaxTable();
                    break;
                case 3:
                    System.out.println("Thank you for using Tax Calculator!");
                    System.exit(0);
            }
        }while(userSelection!=3);

    }
    




    //displays welcome screen
    private static void displayWelcomeScreen(){
        for(int i=0; i<50; i++)
            System.out.print("$");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("WELCOME TO PERSONAL TAX CALCULATOR");
        System.out.println();
        System.out.println();
        for(int i=0; i<50; i++)
            System.out.print("$");
        System.out.println();
        System.out.println();

    }





    //displays program menu
    private static void displayProgramMenu(){
        System.out.println("Please select from followng options-");
        for(String s: programMenu){
            System.out.println(s);
        }
        System.out.print(": ");
    }





    //get user input on program menu
    private static int getUserSelection(){
        int answer=0;
        do{
            answer=getAnswer();
            if(answer<1||answer>3){
                answer=0;
                System.out.println("Invalid selection");
                displayProgramMenu();
            }
        }while(answer==0);
        return answer;
    }




    //get user input from buffer
    private static int getAnswer(){
        Scanner input= new Scanner(System.in);
        int answer=-1;
        try{
            answer=input.nextInt();
        }
        catch(Exception e){
            //empty
        }
        input.nextLine();
        return answer;
    }






    //get filing status from user 
    private static int getFilingStatus(){
        int answer=-1;
        do{
            System.out.println("Select one filing status from below: \n");
            System.out.println(Tax.SINGLE_FILER+". Single Filer");
            System.out.println(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW+". Married jointly or qualified widow(er)");
            System.out.println(Tax.MARRIED_SEPERATELY+". Married seperately");
            System.out.println(Tax.HEAD_OF_HOUSEHOLD+". Head of household");
            answer=getAnswer();
            if(answer<0 || answer>3){
                System.out.println("Invalid selection.\n");
                answer=-1;
            }
        }while(answer==-1);
        return answer;
    }






    //get tax year from user
    private static int getTaxYear(){
        int answer=0;
        do{
            System.out.print("Enter the tax year: ");
            answer=getAnswer();
            if(answer!=2001 && answer!=2009){
                System.out.println("Invalid tax year. select from 2001 and 2009");
                answer=0;
            }
        }while(answer==0);
        return answer;
    }




    

    //get taxable amount from user
    private static double getTaxableAmount(String question){
        Scanner input= new Scanner(System.in);
        double answer=0.0;
        do{
            System.out.print(question);
            try{
                answer=input.nextDouble();
            }
            catch(Exception e){

            }
            if(answer<0){
                System.out.println("Invalid amount.");
            }
        }while(answer<0);
        return answer;
    }





    //calculates tax amount based on tax year and filing status
    private static double calculateTax(int taxYear, int filingStatus, double taxableAmount){
        Tax taxtable=createTaxTable(taxYear,filingStatus,taxableAmount);
        return taxtable.getTax();
    }









    //creates Tax object based on tax year
    private static Tax createTaxTable(int year, int filingStatus, double taxableAmt){
        Tax result=null;
        //create tax tables
        //
        int [][] brackets2001={{27050, 65550,136750,297350,297351},
                                {45200,109250,166500,297350,297351},
                                {22600,54625,83250,148675,148676},
                                {36250,93650,151650,297350,297351}};
        int [][] brackets2009={{8350,33950,82250,171550,372950,372951},
                               {16700,67900,137050,208850,372950,372951},
                               {8350,33950,68525,104425,186475,186476},
                               {11950,45500,117450,190200,372950,372951}};
       double[] rates2001={15,27.5,30.5,35.5,39.1};
       double[] rates2009={10,15,25,28,33,35};

       switch (year){
           case 2001:
               result= new Tax(filingStatus, brackets2001, rates2001,taxableAmt);
               break;
            case 2009:
               result= new Tax(filingStatus, brackets2009, rates2009,taxableAmt);
               break;
       }
       return result;
    }





    //prints tax table for 2001 and 2009 for amount range for each filing status
    private static void printTaxTable(){
        double minAmt= getTaxableAmount("Enter the amount from: ");
        double maxAmt= getTaxableAmount("Enter the amount to: ");
        int []year={2001,2009};
        for(int i=0; i<year.length; i++){
            System.out.println(year[i]+" tax tables for taxable income from $"+minAmt+" to $"+maxAmt);
            printHeader();
            for(double amount=minAmt; amount<=maxAmt; amount+=1000){
                System.out.print(String.format("|%15.2f",amount));
                System.out.printf(String.format("|%15.2f",calculateTax(year[i],Tax.SINGLE_FILER, amount)));
                System.out.printf(String.format("|%15.2f",calculateTax(year[i],Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, amount)));
                System.out.printf(String.format("|%15.2f",calculateTax(year[i],Tax.MARRIED_SEPERATELY, amount)));
                System.out.printf(String.format("|%15.2f|",calculateTax(year[i],Tax.HEAD_OF_HOUSEHOLD, amount)));
                System.out.println();
            }
            printDash(80);
            System.out.println();
        }

    }






    //prints header for tax table
    private static void printHeader(){
        printDash(80);
        System.out.println();
        System.out.print(String.format("|%15s","Taxable"));
        System.out.print(String.format("|%15s","Single"));
        System.out.print(String.format("|%15s","Married Joint "));
        System.out.print(String.format("|%15s","Married "));
        System.out.print(String.format("|%15s|","Head of "));
        System.out.println();
        System.out.print(String.format("|%15s"," Income"));
        System.out.print(String.format("|%15s"," "));
        System.out.print(String.format("|%15s","or Qualifing "));
        System.out.print(String.format("|%15s","Seperate "));
        System.out.print(String.format("|%15s|","House "));
        System.out.println();
        System.out.print(String.format("|%15s"," "));
        System.out.print(String.format("|%15s"," "));
        System.out.print(String.format("|%15s","Widow(er)"));
        System.out.print(String.format("|%15s"," "));
        System.out.print(String.format("|%15s|"," "));
        System.out.println();
        printDash(80);
        System.out.println();
    }





    //prints "-" for parameter times
    private static void printDash(int count){
        for(int i=0; i<count; i++){
            System.out.print("-");
        }
    }


}//end of class



