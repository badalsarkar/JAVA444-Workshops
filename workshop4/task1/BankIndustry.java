//this class stores information about multiple bank


class BankIndustry{
    private Bank[] allBanks;
    private int nextIndex=0;

    //methods
    public BankIndustry(int n){
        if(n>0)
            allBanks=new Bank[n];
    }


    //add a new bank to the industry
    public void addNewBank(int id, double balance, double [][]loanedTo){
        if(nextIndex>=allBanks.length){
            System.out.println("No free space to add new bank");
        }
        else{
            allBanks[nextIndex++]= new Bank(id, balance, loanedTo);
        }

    }


    //get bank by id
    public Bank getBank(int id){
        Bank result=null;
        if(id>=0){
            for(Bank b: allBanks){
                if(b.getId()==id){
                    result=b;
                    break;
                }
            }
        }
        return result;
    }



    //update borrowed from 
    //update the borrowed from list for each bank
    public void updateBorrowedFromList(){
        Bank temp=null;
        for(Bank b: allBanks){
            for(BankLoan item: b.getLoanPortfolio()){
                temp=getBank(item.getBorrowerId());
                if(temp!=null){
                    temp.setBorrowedFrom(b.getId());
                }
                else{
                    System.out.println("Null");
                }
            }
        }
    }



    //print all banks 
    public void printBanks(){
        for(Bank b: allBanks){
            b.print();
        }
    }




    //function to determine the safe and unsafe bank
    //if a bank is unsafe, get the list of lenders to that bank
    //go to each lenders loan portfolio
    //and make the BankLoan to this bank unsafe
    public void evaluateBankSafety(){
        for (Bank b: allBanks){
            if(!b.getSafetyStatus()){
                int[] lenderList=b.getBorrowedFrom();
                for(int id: lenderList){
                    (getBank(id)).updateLoanPortfolio(b.getId(), b.getSafetyStatus());
                }
            }
        }
    }


    //function to print the id of safe banks
    public void printSafeBankId(){
        String safeBankIds="";
        for(Bank b: allBanks){
            if(b.getSafetyStatus()){
                safeBankIds+=(" "+b.getId());
            }
        }
        System.out.println("The safe banks are " +safeBankIds);
    }


    //function to print the id of unsafe banks
    public void printUnsafeBankId(){
        String unsafeBankIds="";
        for(Bank b: allBanks){
            if(!b.getSafetyStatus()){
                unsafeBankIds+=(" "+b.getId());
            }
        }
        System.out.println("The unsafe banks are " +unsafeBankIds);
    }
        


}
