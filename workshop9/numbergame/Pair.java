
//Student Name: Badal Sarkar
//Student ID:137226189




/**
 * this class stores two numbers a a pair
**/
class Pair{
    private double x;
    private double y;

    public Pair(double valX, double valY){
        if(valX>=0 && valY>=0){
            x=valX;
            y=valY;
        }
    }

    @Override 
    public boolean equals(Object o){
        if(o==this){
            return true;
        }

        if(!(o instanceof Pair)){
            return false;
        }

        Pair c=(Pair)o;
        return (Double.compare(x,c.x)==0&& Double.compare(y,c.y)==0) || (Double.compare(x,c.y)==0&& Double.compare(y,c.x)==0);
    }


    //returns the value of x
    public double getX(){
        return x;
    }


    //returns the value of y
    public double getY(){
        return y;
    }


}
