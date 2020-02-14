//Bank class
//this class provides structure for a bank object


class Bank{
    private int id=-1;
    private static double minAsset=0.0;
    private double balance=0.0;
    private BankLoan [] loanPortfolio;
    private int [] borrowedFrom;
    private boolean safe=true;

    //methods
    public Bank(){

    }


    //overloaded constructor
    public Bank(int id, double balance, double[][] loanedTo){
        this.id=id;
        if(dataIsValid(balance, loanedTo)){
            this.balance=balance;
            loanPortfolio= new BankLoan[loanedTo.length];
            for(int i=0; i<loanPortfolio.length; i++){
                loanPortfolio[i]= new BankLoan(loanedTo[i]);
            }
        }
    }


    public static void setMinAsset(double amt){
        if(amt>0){
            minAsset=amt;
        }
    }


    public int getId(){
        return id;
    }




    //set borrowed from 
    public void setBorrowedFrom(int id){
        int length=1;
        int[] temp;
        if(borrowedFrom!=null){
            length=borrowedFrom.length+1;
            temp= new int[length];
            System.arraycopy(borrowedFrom, 0, temp, 0, borrowedFrom.length);
            temp[length-1]=id;
        }
        else{
            temp=new int[length];
            temp[length-1]=id;
        }
        borrowedFrom=temp;
    }


    //get borrowed from
    public int[] getBorrowedFrom(){
        return borrowedFrom.clone();
    }



    //get loaned to
    public BankLoan[] getLoanPortfolio(){
        return loanPortfolio;
    }


    //validate data
    private boolean dataIsValid(double balance, double[][] loanedTo){
        boolean dataIsValid=true;
        //validate data
        if(balance<0)
            dataIsValid=false;
        if(dataIsValid){
            for(double[] loan: loanedTo){
                for(double amt: loan){
                    if(amt<0){
                        dataIsValid=false;
                        break;
                    }
                }
                if(!dataIsValid)
                    break;
            }
        }
        return dataIsValid;
    }




    //function to get the safe status
    public boolean getSafetyStatus(){
        evaluateSafetyStatus();
        return safe;
    }



    //function to determine if a bank is safe
    //a bank is safe if (balance + sum of all safe loans)>=minAsset
    public void evaluateSafetyStatus(){
        double totalAsset=balance;
        for(BankLoan loan:loanPortfolio){
            if(loan.getSafe()){
                totalAsset+=loan.getLoanAmount();
            }
        }
        safe=(totalAsset>=minAsset);
    }


    //function to set loan status
    //this function updates the safety status
    //of a specific bank in the loan portfolio
    public void updateLoanPortfolio(int id, boolean status){
        for (BankLoan loan: loanPortfolio){
            if(loan.getBorrowerId()==id){
                loan.setLoanStatus(status);
            }
        }

    }








    //print
    public void print(){
        System.out.println("The bank id is: " + id);
        System.out.println("The minimum asset is: "+ minAsset);
        System.out.println("The balance is: "+ balance);
        System.out.println("Total banks loaned to :"+ loanPortfolio.length);
        System.out.println("The bank is "+ getSafetyStatus());
        System.out.println("This bank borrowed from following banks: ");
        for(int id: borrowedFrom){
            System.out.println(id);
        }
    }




    
}
