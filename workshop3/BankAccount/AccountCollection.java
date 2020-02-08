
//student Name: Badal Sarkar
//Student Id: 137226189



//this class provides functionality to store
//a collection of accounts
class AccountCollection{
    private Account[] accountCollection;
    private int nextIndex=0;

    //methods
    AccountCollection(int size){
        accountCollection=new Account[size];
    }


    //create new loan account
    public void addLoanAccount(){
        if(nextIndex<accountCollection.length){
            LoanAccount newAccount= new LoanAccount();
            accountCollection[nextIndex++]=newAccount;
            UserInteraction.printMsg("New account created with id: ", newAccount.getId());
        }
        else{
            UserInteraction.printError("Account collection full. No accounts can be created");
        }
    }


    
    //create new chequing account
    public void addChequingAccount(){
        if(nextIndex<accountCollection.length){
            ChequingAccount newAccount= new ChequingAccount();
            accountCollection[nextIndex++]=newAccount;
            UserInteraction.printMsg("New account created with id: ", newAccount.getId());
        }
        else{
            UserInteraction.printError("Account collection full. No accounts can be created");
        }
    }




    //find an account with id
    public Account getAccount(int id){
        Account result=null;
        for(Account act: accountCollection){
            if(act.getId()==id){
                result=act;
                break;
            }
        }
        return result;
    }


            
}
