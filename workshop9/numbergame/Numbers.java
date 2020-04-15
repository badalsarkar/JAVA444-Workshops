
//Student Name: Badal Sarkar
//Student ID:137226189
//
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Vector;
import java.util.Iterator;
import java.math.*;

/** this class provides functionality to generate two numbers
 *  and validates some mathematical operations on those numbers
 *  this class guarantees that the same set of numbers will not
 *  be used more than once i.e {1,2} will be used only once.
**/
class Numbers {
    private final int TOTAL_MATH_OPERATION=4; //sum, subs, multiply, division
    private final int ELEMENT_IN_SET=2;     //used to calculate nCr. this is r
    //these two value is used to generate 
    //random numbers between this range
    private int minValue;
    private int maxValue;
    //this is used to limit the number of times the random number
    //generation is to be done. 
    private int maxCombination=501501;
    private Pair currentPair;
    //usedNumbers tracks already randomly generated numbers
    //to make sure same number is not used twice
    private Vector<Pair> usedPair;
    //results holds the value of different mathematical calculations
    //initially supports sum, subs, multiply, division
    //the order is important here-first item is sum, second is 
    //subs and so on
    //private LinkedHashSet<Double> results; 
    private HashSet<Vector<Double>> results;

    private Random randomGenerator;



    /**
     * construct an object
     * @param   minv    the lower level of random number range
     * @param   maxV    the upper level of random number range
    **/
    public Numbers(int minV, int maxV){
        if(minV >=0 && maxV>0){
            minValue=minV;
            maxValue=maxV;
            usedPair= new Vector<Pair>();
            //results=new LinkedHashSet<Double>(TOTAL_MATH_OPERATION);
            results= new HashSet<Vector<Double>>();
            randomGenerator= new Random();
        }
    }





    /**
     * getter for x
     * @return the x 
    **/
    public double getX(){
        return currentPair.getX();
    }



    /**
     * getter for y
     * @return the y
    **/
    public double getY(){
        return currentPair.getY();
    }




    /**
     * generates two random number within range, 
     * guarantees the numbers were not used before
     * updates x and y with two values
    **/
    public void generate()throws Exception{
        //if there is at least two unused element 
        //proceed to generate two random numbers
        if(maxCombination>0){
            //generate a combination
            boolean cont=true;
            do{
                Pair tempPair= new Pair((double)randomGenerator.nextInt(maxValue+1),(double)randomGenerator.nextInt(maxValue+1));
                if(!usedPair.contains(tempPair)){
                    cont=false;
                    currentPair=tempPair;
                    usedPair.add(tempPair);
                }
            }while(cont);
        }
        else{
            throw new Exception("allCombinationsUsed");
        }
    }





    /**
     * performs the mathematical operation and store the results in 
     * a set and updates the result 
    **/ 
    public void calculate(){
        double x=currentPair.getX();
        double y=currentPair.getY();
        Vector<Double> result= new Vector<Double>();

        result.add(Double.valueOf(x+y));
        result.add(Double.valueOf(x-y));
        result.add(Double.valueOf(x*y));
        result.add(Double.valueOf(x/y));
        //remove previous results
        results.clear();
        this.results.add(result);
    }





    /**
     * validates user answer against correct answer
     * @return the number of correct answer
    **/
    public int validateAnswer(HashSet<Vector<Double>> answer){
        int correctAnswer=0;
        Vector<Double> result= (this.results.iterator()).next();
        Iterator<Double> iterAnswer=((answer.iterator()).next()).iterator();

        for(Double d: result){
            if(iterAnswer.hasNext()){
                BigDecimal a=new BigDecimal(d.toString());
                BigDecimal b= new BigDecimal((iterAnswer.next()).toString());
                MathContext m= new MathContext(2);
                a=a.round(m);
                b=b.round(m);
                //if(Double.compare(d,iterAnswer.next())==0){
                 //   correctAnswer++;
                //}
                if(a.compareTo(b)==0){
                    correctAnswer++;
                }
            }
        }

        return correctAnswer;
    }




}//end of class


