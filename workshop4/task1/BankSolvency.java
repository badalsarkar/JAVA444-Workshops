//this is the main class




public class BankSolvency{

    public static void main(String[] args){
        int totalBank= UserInteraction.getNumber("Number of Banks: ");
        int minAsset= UserInteraction.getNumber("Minimum asset limit: ");
        //set minimum asset
        Bank.setMinAsset(minAsset);
        //BankIndustry is a collection of all banks
        //instantiate a new bank industry
        BankIndustry myIndustry=new BankIndustry(totalBank);
        //print instruction to input bank information
        System.out.println("Enter the bank information as following-");
        System.out.println("Bank Id [space] Balance [space] total banks loaned to [space] Bank Id [space] Amount loaned");
        try{
            //read user input for new bank
            //create individual bank
            for(int i=0;i<totalBank;i++){
                String line=UserInteraction.getLine(); 
                String[] lineArray= line.split(" ");
                double[][]loanedTo= extractLoanedToData(lineArray, Integer.parseInt(lineArray[2]));
                //create new bank and add to bank industry
                myIndustry.addNewBank(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), loanedTo);
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






    // extract data starting from array index 3
    // there will "length" number of rows
    // each row has two column- id and amount
    private static double [][] extractLoanedToData(String[] data, int length){
        int pos=3;
        double [][]result= new double[length][2];
        for(int i=0; i<length; i++){
            try{
                if(data[0]!=data[pos]){
                    result[i][0]=Double.parseDouble(data[pos++]);
                    result[i][1]=Double.parseDouble(data[pos++]);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return result;
        
    }
}
