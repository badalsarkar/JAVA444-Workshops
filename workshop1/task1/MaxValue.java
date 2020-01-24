//
//
import java.util.Scanner;

class Location{
    int row, column;
    double maxValue;

    //methods
    Location(int r, int c, double maxV){
        row=r;
        column=c;
        maxValue=maxV;
    }

    void print(){
        System.out.println("The max value is :" + maxValue);
        System.out.println("The location is [r][c]: " + "["+row+"]"+"["+column+"]");
    }

}


class MaxValue{
    public static void main (String[] args){
        int row=0, column=0;
        double [][]numbers;
        boolean keepReading;
        Scanner input= new Scanner(System.in);

        //ask user for array dimension
        //ensure only integer value is entered
        do{
            keepReading=false;
            try{
                System.out.print("Enter the number of rows and columns in array: ");
                row=input.nextInt();
                column=input.nextInt();
            }
            catch(Exception e){
                System.out.println("!!!Only enter integer value!!! \n");
                input.nextLine();
                keepReading=true;
            }
        }while(keepReading);
        
        //create array
        numbers=new double [row][column];

        //print empty line
        System.out.println();
        
        //get the array elements
        //ensure only numeric value is given
        do{
            keepReading=false;
            System.out.println("Enter the array: ");
                try{
                    for(int i=0; i<row; i++){
                        for(int j=0; j<column; j++){
                            numbers[i][j]=input.nextDouble();
                        }
                    }
                }
                catch(Exception e){
                    System.out.println("!!!Only enter numeric value!!! \n");
                    //empty the buffer
                    input.nextLine();
                    keepReading=true;
                }
        }while(keepReading);

        Location maxLocation = maxValue(numbers);
        maxLocation.print();
    }



    //method to find the maximum value and location
    public static Location maxValue(double [][] values){
        int row=0, col=0;
        double maxvalue=values[0][0];
        for(int i=0; i<values.length; i++){
            for (int j=0; j<values[i].length; j++){
                if(values[i][j]>maxvalue){
                    maxvalue=values[i][j];
                    row=i;
                    col=j;
                }
            }
        }

        //instantiate location object
        Location maxValueLocation=new Location(row, col, maxvalue);
        return maxValueLocation;
    }

};
