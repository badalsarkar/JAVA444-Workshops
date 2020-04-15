


//Tester for matrix addition

public class MatrixAdditionTest{
    private static int rowSize=2000;
    private static int colSize=2000;

    public static void main(String[] args){
        double [][]data1= new double[rowSize][colSize];
        double [][] data2= new double [rowSize][colSize];
        
        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                data1[i][j]=Math.random()*rowSize;
                data2[i][j]=Math.random()*rowSize;
            }
        }
        System.out.println("Matirx1("+rowSize+"X"+colSize+") generated with random number");
        System.out.println("Matirx2("+rowSize+"X"+colSize+") generated with random number");
        System.out.println();
        long startTime=System.nanoTime();
        try{
            MatrixAddition.calculate(data1,data2);
        }
        catch(Exception e){
            System.out.println(e);
        }
        long endTime=System.nanoTime();
        long nonThdTime=endTime-startTime;

        startTime=System.nanoTime();
        MatrixAdditionThread.calculate(data1, data2, 1000);
        endTime=System.nanoTime();
        long thdTime=endTime-startTime;
        System.out.println("The summary of time taken");
        System.out.println("Main Thread \t Additional Thread");
        System.out.println((double)nonThdTime/1000000000+"second" +"\t"+(double)thdTime/1000000000+"second");

    }




}

