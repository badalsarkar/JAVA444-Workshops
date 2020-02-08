//student Name: Badal Sarkar
//Student Id: 137226189
import java.time.LocalDate;




//Account class provides accoutn related functionality
class Account{
    private static int id=0;
    private double balance;
    private double annualInterestRate;
    private LocalDate dateCreated;
    private String []options={"View balance", "View interest rate", "View open date", "View account status"};

    //methods
    public Account(){
        id++;
        dateCreated=LocalDate.now();
    };
    public Account(double initialBalance){
        if(initialBalance<0)
            return;
        this.balance=initialBalance;
        id++;
        dateCreated=LocalDate.now();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        if(id>0)
            this.id=id;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        if (balance>0){
            this.balance=balance;
        }
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double rate){
        if(rate>0){
            this.annualInterestRate=rate/100;
        }
    }

    public LocalDate getDateCreated(){
        return dateCreated;
    }


    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return (balance*getMonthlyInterestRate());
    }


    public boolean withdraw(double amount){
        if(balance<amount){
            UserInteraction.printError("Not enough balance");
            return false;
        }
        balance-=amount;
        UserInteraction.printMsg("Withdrawal successful. The current balance is : ", getBalance());
        return true;
    }


    public boolean deposit(double amount){
        if(amount<=0)
            return false;
        balance+=amount;
        UserInteraction.printMsg("Deposit successful. The current balance is : ", getBalance());
        return true;
    }

    public void printAccountStatus(){}
        


}
