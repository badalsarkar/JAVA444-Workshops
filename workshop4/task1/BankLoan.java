//Student name: Badal Sarkar
//Student id: 137226189
//


//this class provides structure and functionality 
//for a loan provided to a bank


class BankLoan{
    private int borrowerId=-1;
    private double loanAmount=0.0;
    private boolean safe=true;

    //methods
    public BankLoan(){

    }

    public BankLoan(int id, double amt, boolean status){
        if(id>=0 && amt >0){
            borrowerId=id;
            loanAmount=amt;
            safe=status;
        }
    }

    //the constructor accepts an array with two elements 
    //the first elements is the borrower id
    //the secone element is the amount of loan
    //the value for safe remains the default value
    public BankLoan(double[] loanInfo){
        if(loanInfo!=null&& loanInfo.length==2){
            borrowerId=(int)loanInfo[0];
            loanAmount=loanInfo[1];
        }
    }


    //sets the borrower id
    public void setBorrowerId(int id){
        if(id>=0)
            borrowerId=id;
    }


    //returns the borrower id
    public int getBorrowerId(){
        return borrowerId;
    }



    //sets the loan status
    public void setLoanStatus(boolean status){
        safe=status;
    }



    //returns the safety status
    public boolean getSafe(){
        return safe;
    }




    //returns the loan amount
    public double getLoanAmount(){
        return loanAmount;
    }
}
