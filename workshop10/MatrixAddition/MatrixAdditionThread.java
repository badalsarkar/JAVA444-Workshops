



/**
 * the class provides functionality to sum two 
 * matrices using thread
 * the calss provides one static method
 *
**/
class MatrixAdditionThread{
    /**
     * adds two metrices using thread
     * each thread is responsible for performing calculation 
     * on specific number of elements
     * @param   mtx1    first matrix 
     * @param   mtx2    second matrix 
     * @param   elmtPrThd   the number of element the thread will process   
     * @return  a two dimensional array of double holding the sum
    **/
    public static double[][] calculate(double[][] mtx1, double[][] mtx2, int elmtPrThd){
        //total required thread
        int thdCnt= (int)(Math.ceil(mtx1.length/elmtPrThd))>4?4:(int)Math.ceil(mtx2.length/elmtPrThd);
        //array to hold 
        ThreadAddition [] thdColl=new ThreadAddition[thdCnt];

        int startPos=0;
        int endPos=elmtPrThd-1;

        for(int i=0; i<thdCnt; i++){
            if(i==thdCnt-1){
                endPos=mtx1.length-1;
                thdColl[i]=ThreadAddition.createAndStart(mtx1, mtx2, startPos, endPos);
            }
            else{
                thdColl[i] = ThreadAddition.createAndStart(mtx1, mtx2,startPos, endPos); 
                startPos= endPos + 1;
                endPos= startPos + elmtPrThd-1;
            }
        }

        for(int i=0; i<thdCnt; i++){
            thdColl[i].join();
        }

        return ThreadAddition.getResult();

    }

}









/**
 * this class performs addition of two matrices using thread
 * the class contains three static member.  
**/
class ThreadAddition implements Runnable{
    private static double [][] param1;
    private static double [][] param2;
    private static double [][] result;
    private int startPos;
    private int endPos;
    private Thread th;



    public ThreadAddition(double[][] a, double [][] b, int startPos, int endPos){
        if(a!=null && b!=null){
            setParam(a,b);
            this.startPos=startPos;
            this.endPos=endPos;
            this.th=new Thread(this);
        }
    }


    //factory method that creates and starts a thread
    public static ThreadAddition createAndStart(double[][]param1, double [][] param2, int startPos, int endPos){
        ThreadAddition ta= new ThreadAddition(param1, param2, startPos, endPos);
        ta.th.start();
        return ta;
    }



    @Override
    public void run(){
        int i=this.startPos;
        int j=0;
        try{
            for(i=this.startPos; i<=this.endPos; i++){
                for(j=0; j<param1[i].length; j++){
                    result[i][j]=param1[i][j]+param2[i][j];
                }
            }
        }
        catch(Exception e){
        }
    }



    //setter for result
    private static void setResult(int row, int col, double value){
        result[row][col]=value;
    }

    //static method for setting param
    private static void setParam(double [][] a, double [][] b){
            param1= new double [a.length][];
            param2= new double [b.length][];
            for(int i=0; i< a.length; i++){
                param1[i]= new double [a[i].length];
                //now clone the members
                param1[i]=a[i].clone();
            }
            for(int i=0; i< b.length; i++){
                param2[i]= new double [b[i].length];
                //now clone the members
                param2[i]=b[i].clone();
            }

            result=new double[param1.length][param1[0].length];

    }


    //static method for getting result
    public static double[][] getResult(){
        double[][] tempResult= new double[result.length][];
        for(int i=0; i<tempResult.length; i++){
            tempResult[i]=new double [result[i].length];
            tempResult[i]=result[i].clone();
        }
        return tempResult;
    }


    //join thread
    public void join(){
        try{
            th.join();
        }
        catch(InterruptedException ex){
            System.out.println(ex);
        }
    }


}






