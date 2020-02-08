//student Name: Badal Sarkar
//Student Id: 137226189


//derived from account class
//provides functionality for chequing account
class ChequingAccount extends Account{
    private int cqId=0;


    //methods
    public ChequingAccount(){
        super();
        cqId=super.getId();
        setBalance(UserInteraction.getAmount("Enter the amount to deposit: ", 1));
    }


    public int getId(){
        return cqId;
    }


    public void printAccountStatus(){
        System.out.print(String.format("The account number is %d\n", getId()));
        System.out.print(String.format("The account was opened in %s\n", getDateCreated()));
        System.out.print(String.format("The current balance is %.2f\n", getBalance()));
        System.out.println("\n");
    }
}
