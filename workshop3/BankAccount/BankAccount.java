//student Name: Badal Sarkar
//Student Id: 137226189

import java.time.LocalDate;
import java.util.Scanner;


//This is the main class
public class BankAccount{
    //available program menue
    static final String[] menus={"Create chequing account", "Create loan account", "View account", "Deposit money", "Withdraw money", "Print payment schedule", "Exit"};
    //available type of accounts
    static final String[] accountType={"Chequing", "Loan Account"};



    //methods
    public static void main(String []args){
        AccountCollection allAccounts= new AccountCollection(50);
        int userSelection=0;
        int id=0;
        double amt=0;
        do{
            userSelection=UserInteraction.getNumber("Please choose from the following options: ", menus, 1, menus.length);

            switch (userSelection){
                case 1:
                    allAccounts.addChequingAccount();
                    break;
                case 2:
                    allAccounts.addLoanAccount();
                    break;
                //print account status
                case 3:
                    id=UserInteraction.getNumber("Enter the account id: ");
                    Account act=allAccounts.getAccount(id);
                    act.printAccountStatus();
                    break;
                //deposit money
                case 4:
                    id=UserInteraction.getNumber("Enter the account id: ");
                    act=allAccounts.getAccount(id);
                    amt= UserInteraction.getAmount("Enter the amount to deposit: ", 1);
                    act.deposit(amt);
                    break;
                //withdraw money
                case 5:
                    id=UserInteraction.getNumber("Enter the account id: ");
                    act=allAccounts.getAccount(id);
                    amt=UserInteraction.getAmount("Enter the amount to withdraw: ", 1);
                    act.withdraw(amt);
                    break;
                //print payment table
                //shows monthly payment
                case 6:
                    id=UserInteraction.getNumber("Enter the account id: ");
                    act=allAccounts.getAccount(id);
                    if(act instanceof LoanAccount){
                        LoanAccount lAct= (LoanAccount)act;
                        lAct.printPmtSchedule();
                    }
                    else{
                        UserInteraction.printError("Not a loan account");
                    }
                    break;
                case 7:
                    System.out.println("Thnak you for Banking");

            }
        }while(userSelection!=7);
    }

}//end of class


        

