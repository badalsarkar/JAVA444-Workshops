//Student Name: Badal Sarkar
//Student ID: 
//
//
//
import java.util.Scanner;


public class CalculateTax{
    //static variable
    private static String[] programMenu={"1. Compute Personal Income Tax",
        "2. Print the tax tables for taxable incomes (with range)", 
        "3. Exit"};

    public static void main(String[] args){
        displayWelcomeScreen();
        displayMenu();
        int userSelection=getUserSelection();
        switch (userSelection){
            case 1:
                int taxYear=getTaxYear();
                int filingStatus= getFilingStatus();
                double taxableAmount=getTaxableAmount("Enter the taxable amount: ");
                double tax=calculateTax(taxYear, filingStatus, taxableAmount);
                System.out.println("the tax is :"+tax);
                break;
            case 2:
                printTaxTable();
                break;
            case 3:
                System.out.println("Thank you for using Tax Calculator!");
                System.exit(0);
        }

    }
    






    private static void displayMenu(){
        System.out.println("Please select from followng options-");
        for(String s: programMenu){
            System.out.println(s);
        }
        System.out.print(": ");
    }

    private static void displayWelcomeScreen(){
        for(int i=0; i<50; i++)
            System.out.print("+");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("WELCOME TO PERSONAL TAX CALCULATOR");
        System.out.println();
        System.out.println();
        for(int i=0; i<50; i++)
            System.out.print("+");
        System.out.println();
        System.out.println();

    }




    private static double calculateTax(int taxYear, int filingStatus, double taxableAmount){
        Tax taxtable=createTaxTable(taxYear,filingStatus,taxableAmount);
        return taxtable.getTax();
    }


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

    private static int getUserSelection(){
        int answer=0;
        do{
            answer=getAnswer();
            if(answer<1||answer>3){
                answer=0;
                System.out.println("Invalid selection");
                displayMenu();
            }
        }while(answer==0);
        return answer;
    }



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



    private static void printTaxTable(){
        double minAmt= getTaxableAmount("Enter the amount from: ");
        double maxAmt= getTaxableAmount("Enter the amount to: ");
        int []year={2001,2009};
        for(int i=0; i<year.length; i++){
            for(double amount=minAmt; amount<=maxAmt; amount+=1000){
                System.out.print(amount+"\t");
                System.out.print(calculateTax(year[i],Tax.SINGLE_FILER, amount)+"\t");
                System.out.print(calculateTax(year[i],Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, amount)+ "\t");
                System.out.print(calculateTax(year[i],Tax.MARRIED_SEPERATELY, amount) + "\t");
                System.out.print(calculateTax(year[i],Tax.HEAD_OF_HOUSEHOLD, amount)+ "\t");
                System.out.println();
            }
        }

    }

}



