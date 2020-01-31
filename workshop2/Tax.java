//Student Name: Badal Sarkar
//Student ID:137226189
//



class Tax{
    //static final variable: class instance variable
    public static final int SINGLE_FILER=0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW=1;
    public static final int MARRIED_SEPERATELY=2;
    public static final int HEAD_OF_HOUSEHOLD=3;
    private int filingStatus;
    private int[][] brackets;
    private double[]rates;
    private double taxableIncome;

    //methods
    public Tax(){
        //empty
    }


    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome){
        //filingStatus should be between 0 to 4
        //otherwise the object will be in default status
        if(filingStatus>=0 && filingStatus<4){
            this.filingStatus=filingStatus;
            this.brackets=brackets;
            this.rates=rates;
            this.taxableIncome=taxableIncome;
        }
    }



    //getter and setters
    public int getFilingStatus(){
        return filingStatus;
    }



    public void setFilingStatus(int status){
        //filingStatus must be between 0 and 4
        //otherwise the variable is in default value
        if(status>=0 && status<4){
            filingStatus=status;
        }
    } 



    public int[][] getBrackets(){
        //must return a clone of brackets as
        //brackets is mutable
        return deepCopy(brackets);
    }



    public void setBrackets(int[][] brackets){
        //brackets only contains positive number 
        //if negative number is provided in the 
        //parameter, don't change the value of brackets
        //and exit.
        for(int[] items: brackets){
            for(int value:items){
                if(value<0)
                    return;
            }
        }

        this.brackets=deepCopy(brackets);
        
    }



    public int[] getRates(){
        int[] result= {0};
        if(rates.length>0){
            for(int i=0; i<rates.length; i++){
                result[i]=(int)rates[i];
            }
        }
        return result;
    }




    public void setRates(double[] rates){
        //rates can only be positive
        //otherwise don't change the variable
        for(double rate: rates){
            if(rate<0)
                return;
        }

        //deep copy the parameter
        this.rates=rates.clone();
    }



    public double getTaxableIncome(){
        return taxableIncome;
    }


    public void setTaxableIncome(double taxableIncome){
        //taxable income must be positive
        if(taxableIncome>0){
            this.taxableIncome=taxableIncome;
        }
    }


    public double getTax(){
        //find the tax bracket the taxable income
        //falls into
        int applicableBracket=brackets[filingStatus].length-1;
        for(int i=0; i<brackets[filingStatus].length; i++){
            if(brackets[filingStatus][i]>=taxableIncome){
                applicableBracket=i;
                break;
            }
        }
        
        //now the bracket is found, calculate the tax
        double totalTax=0.0;
        double taxedAmount=0;
        for(int i=0; i<applicableBracket; i++){
            totalTax+=(brackets[filingStatus][i]-taxedAmount)*(rates[i]/100);
            taxedAmount=brackets[filingStatus][i];
        }
        totalTax+=(taxableIncome-taxedAmount)*(rates[applicableBracket]/100);

        return totalTax;
    }


    private int[][] deepCopy(int[][] src){
        //deepCopy function
        //deep copies two dimensional array and return 
        //new array
        int [][]copy;
        if(src.length==0){
            return null;
        }

        copy= new int[src.length][];
        for(int i=0; i<src.length; i++){
            copy[i]=src[i].clone();
        }
        return copy;
    }



}
