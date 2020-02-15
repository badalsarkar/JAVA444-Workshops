//Student name: Badal Sarkar
//Student id: 137226189
//




//this is the main class
public class BankSolvency{
        private static int totalBank;

    public static void main(String[] args){
        totalBank= UserInteraction.getNumber("Number of Banks: ");
        int minAsset= UserInteraction.getNumber("Minimum asset limit: ");
        //set minimum asset
        Bank.setMinAsset(minAsset);
        //BankIndustry is a collection of all banks
        //instantiate a new bank industry
        BankIndustry myIndustry=new BankIndustry(totalBank);
        //print instruction to input bank information
        try{
            //read user input for new bank
            //create individual bank
            for(int i=0;i<totalBank;i++){
                System.out.println();
                UserInteraction.printMsg("Enter the information for bank :",i);
                double balance= UserInteraction.getAmount("Enter the balance :", 1);
                double[][] loanedTo=getLoanInfo(i);
                //create new bank and add to bank industry
                myIndustry.addNewBank(i, balance, loanedTo);
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
        //update the borrower list for all banks in the industry
        myIndustry.updateBorrowedFromList();
        //evaluate the safety status of all banks in the industry
        myIndustry.evaluateBankSafety();
        //print the safety status of all banks in the industry
        myIndustry.printSafeBankId();
        //print id of unsafe banks 
        myIndustry.printUnsafeBankId();

    }//end of main








    //function to get loan information
    // this function ask user to input loan information
    // then creates a two dimensional array and returns it
    private static double[][] getLoanInfo(int id){
        System.out.println("Enter the information of loans provided to different banks: ");
        double[][] loan= new double[totalBank-1][];
        int index=0;
        for(int i=0; i<totalBank && index<loan.length; i++){
            if(i!=id){
                loan[index]=new double [2];
                loan[index][0]=i;
                System.out.print("Loan provided to bank " +i);
                loan[index][1]=UserInteraction.getAmount(": ",0.0);
                index++;
            }
        }
        return loan;
    }
}
