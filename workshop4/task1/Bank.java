//Student name: Badal Sarkar
//Student id: 137226189
//



//Bank class
//this class provides structure and functionality for a bank object
//


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
        int length=0;
        if(dataIsValid(balance, loanedTo)){
            this.balance=balance;
            for(int i=0; i<loanedTo.length; i++){
                if(loanedTo[i][1]!=0){
                    length++;
                }
            }
            loanPortfolio= new BankLoan[length];
            length=0;
            for(int i=0; i<loanedTo.length; i++){
                if(loanedTo[i][1]!=0){
                    loanPortfolio[length]= new BankLoan(loanedTo[i]);
                    length++;
                }
            }
        }
    }



    //function to set minAsset
    public static void setMinAsset(double amt){
        if(amt>0){
            minAsset=amt;
        }
    }



    //function to get bank's id
    public int getId(){
        return id;
    }




    //set borrowed from 
    //this function add a new entry to the borrowedFrom array
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

    
}
