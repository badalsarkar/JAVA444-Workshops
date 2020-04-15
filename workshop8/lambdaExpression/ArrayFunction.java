


 interface ArrayProcessor{
    double apply (double [] array);
}


//a class
public class ArrayFunction{
    public static final ArrayProcessor getMaxValue=(double [] array)->{
        double maxValue=array[0];
        for(int i=0; i<array.length; i++){
            if(maxValue<array[i]){
                maxValue=array[i];
            }
        }
        return maxValue;
    };

    public static final ArrayProcessor getMinValue=(double [] array)->{
        double minValue=array[0];
        for(int i=0; i<array.length; i++){
            if(minValue>array[i]){
                minValue=array[i];
            }
        }
        return minValue;
    };


    public static final ArrayProcessor getSum=(double [] array)->{
        double sum=0.0;
        for(double s:array){
            sum+=s;
        }
        return sum;
    };

    public static final ArrayProcessor getAverage=(double [] array)->(getSum.apply(array))/array.length;


    public static ArrayProcessor counter(double value){
        ArrayProcessor count=(double [] array)->{
            double result=0;
            for(double v:array){
                if(value==v){
                    result++;
                }
            }
            
            return result; 
        };
        return count;
    }


    public static void main (String [] args){
        double [] data={1.1,1.2,1.3,1.4};
        System.out.println("The max value is " + getMaxValue.apply(data));
        System.out.println("The min value is " + getMinValue.apply(data));
        System.out.println("The sum is " + getSum.apply(data));
        System.out.println("The average is " + getAverage.apply(data));
        System.out.println("The number 1.1 occured in the array for " + counter(1.1).apply(data));


    }




}
