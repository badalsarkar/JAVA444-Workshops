//student Name: Badal Sarkar
//Student Id: 137226189

import java.util.Scanner;
import java.time.LocalDate;



//this class provides functionality to create loan account
class LoanAccount extends Account{
    private int lnId=1;
    private double principalAmount;
    private double tenure;
    //private tenureInYear;
   //private tenureInMonth;
    private int yearlyPmtNo;
    private double adjustedInterest;
    private double installAmount;
    private int totalInstallmentNo;
    private int paidInstallmentNo;
    private AmortizationTable pmtSchedule;
    private String[] options={};
    private String[] availableTenure={"6 Months", "1 Year", "2 Years", "3 Years", "4 Years", "5 Years"};
    private String[] availablePmtFreq={"Monthly", "Bi-monthly", "Quarterly", "Semi-annually", "Yearly"};

    
    //methods
    LoanAccount(){
        super();
        lnId=super.getId();
        principalAmount=UserInteraction.getAmount("How much money do you need?", 1);
        setBalance(principalAmount);
        tenure=askTenure();
        yearlyPmtNo=askPaymentFrequency();
        totalInstallmentNo=(int)(tenure*yearlyPmtNo);
        super.setAnnualInterestRate(RateChart.getRate(tenure));
        adjustedInterest=RateChart.getRate(tenure)/yearlyPmtNo;
        //create amortization table
        pmtSchedule= new AmortizationTable(principalAmount, totalInstallmentNo, adjustedInterest,LocalDate.now(),yearlyPmtNo);  
        paidInstallmentNo=0;
    }



    //get loan tenure
    private double askTenure(){
        int result=UserInteraction.getNumber("Select the loan tenure from below:",availableTenure,1,availableTenure.length); 
        double tenure=0;
        switch (result){
            case 1:
                tenure=.5;
                break;
            case 2:
                tenure=1;
                break;
            case 3:
                tenure=2;
                break;
            case 4:
                tenure=3;
                break;
            case 5:
                tenure=4;
                break;
            case 6:
                tenure=5;
        }
        return tenure;
    }





    //get payment frequency
    private int askPaymentFrequency(){
        int result=0;
        result= UserInteraction.getNumber("Choose from the below payment frequency: ", availablePmtFreq,1, availablePmtFreq.length); 
        switch (result){
            case 1:
                result=12;
                break;
            case 2:
                result=2;
                break;
            case 3:
                result=4;
                break;
            case 4:
                result=6;
        }
        return result;
    }




    //print payment table
    //shows monthly payment, interest amount, remaining balance
    public void printPmtSchedule(){
        pmtSchedule.print();
    }



    //returns account id
    public int getId(){
        return lnId;
    }




    //prints account status
    public void printAccountStatus(){
        System.out.print(String.format("Account number is %d\n", lnId));
        System.out.print(String.format("Account balance is %.2f\n", getBalance()));
        System.out.print(String.format("The principal loan amount is %.2f\n", principalAmount));
        System.out.print(String.format("The interest rate is %.2f\n", (getAnnualInterestRate()*100*100)));
        System.out.print(String.format("The account was created on %s\n", getDateCreated()));
        System.out.print(String.format("Total no of required payment is %d\n", totalInstallmentNo));
        System.out.print(String.format("Total payment made is %d\n", paidInstallmentNo));
        System.out.println("\n");
    }

    
}

