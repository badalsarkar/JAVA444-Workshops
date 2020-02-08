//student Name: Badal Sarkar
//Student Id: 137226189

import java.time.LocalDate;


//this class provides functionality to create a payment schedule
class AmortizationTable{
    private int []installmentNo;
    private LocalDate [] installmentDate;
    private double [] installmentPayment;
    private double [] interestPayment;
    private double[] principalPayment;
    private double [] principalBalance;

    public AmortizationTable(double prAmount, int totalPaymentNo, double adjustedInterest, LocalDate startDate, int yearlyInstallmentNo){
        //validate data
        if(prAmount<=0 ||  totalPaymentNo<=0 || adjustedInterest<=0 || yearlyInstallmentNo<=0){
            System.out.println("Invalid data");
            return;
        }

        //for 5 year loan and 12 installment in a year total installment is 5*12=60
        //allocate array size
        installmentNo=new int[totalPaymentNo];
        installmentDate=new LocalDate[totalPaymentNo];
        installmentPayment= new double [totalPaymentNo];
        interestPayment=new double[totalPaymentNo];
        principalPayment=new double[totalPaymentNo];
        principalBalance=new double[totalPaymentNo];

        //calculate the monthly payment
        double monthlyPay= calculateMonthlyInstallment(prAmount,adjustedInterest,totalPaymentNo);

        //produce table
        for(int i=0; i<totalPaymentNo-1; i++){
            installmentNo[i]=i+1;
            installmentDate[i]= startDate;
            //now startDate hold the next month value
            startDate=installmentDate[i].plusMonths(12/yearlyInstallmentNo);
            //interest is calcuated on previous balance * monthly/half yearly/ other
            //interest rate
            installmentPayment[i]=monthlyPay;
            interestPayment[i]=prAmount*(adjustedInterest);
            principalPayment[i]=monthlyPay-interestPayment[i];
            principalBalance[i]=prAmount-principalPayment[i];
            prAmount-=principalPayment[i];
        }

        //fill the last installment 
        installmentNo[totalPaymentNo-1]=totalPaymentNo;
        installmentDate[totalPaymentNo-1]=startDate;
        interestPayment[totalPaymentNo-1]=prAmount*(adjustedInterest);
        principalPayment[totalPaymentNo-1]=prAmount;
        installmentPayment[totalPaymentNo-1]=prAmount-interestPayment[totalPaymentNo-1];
        principalBalance[totalPaymentNo-1]=prAmount-principalPayment[totalPaymentNo-1];
    }



    //calculate monthly installment payment

    private double calculateMonthlyInstallment(double principal, double rate, int totalInstallment ){

        //the formula is "principal*(
        double result;
        result=(principal*rate)/(1-Math.pow(1+rate, -totalInstallment));
        return result;
    }



    //print amortization table
    public void print(){
        printHeader();
        for(int i=0; i<this.installmentNo.length; i++){
            System.out.print(String.format("|%18d", installmentNo[i]));
            System.out.print(String.format("|%18s",installmentDate[i]));
            System.out.print(String.format("|%18.2f",installmentPayment[i]));
            System.out.print(String.format("|%18.2f",interestPayment[i]));
            System.out.print(String.format("|%18.2f", principalPayment[i]));
            System.out.print(String.format("|%18.2f", principalBalance[i]));
            System.out.print("|");
            System.out.println();
        }
    }

    private void printHeader(){
        System.out.print(String.format("|%18s", "Installment no"));
        System.out.print(String.format("|%18s", "Payment Date"));
        System.out.print(String.format("|%18s", "Monthly Payment"));
        System.out.print(String.format("|%18s", "Interest Payment"));
        System.out.print(String.format("|%18s", "Principal Payment"));
        System.out.print(String.format("|%18s", "Principal Balance"));
        System.out.print("|");
        System.out.println();
            

    }
}
            





