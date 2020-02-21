//Studen Name: Badal Sarkar
//Student Id: 137226189
//Date: Feb 21, 2020


/**
 * {@code AsciiInfo} class holds different information regarding
 * ASCII table.
*/

class AsciiInfo{
    //these are the decimal value taken fro ASCII Table
    private static final int[][] SPECIAL_CHAR_RANGE={{0,47},{58,64},{91,96},{123,127}};
    private static final int [] NUMERIC_RANGE={48,57};
    private static final int [] SMALL_ALPHA_RANGE={97,122};
    private static final int [] CAP_ALPHA_RANGE={65,90};



    /**
     * check if the given char falls within SPECIAL_CHAR_RANGE
     * @param c a char to be checked
     * @return boolean true if falls within range
    */
    public static boolean isSpecialChar(char c){
        boolean result=false;
        for(int[] range: SPECIAL_CHAR_RANGE){
            result=isWithinRange(range, (int)c);
            if(result)
                break;
        }
        return result;
    }







    /**
     * check if given char falls within NUMERIC_RANGE
     * @param c a char to be checked
     * @return boolean true if falls within range
    */
    public static boolean isNumeric(char c){
        return isWithinRange(NUMERIC_RANGE, (int)c);
    }





    /**
     * check if given char falls with SMALL_ALPHA_RANGE or CAP_ALPHA_RANGE 
     * @param c a char to checked
     * @return boolean true if falls within range
    */
    public static boolean isAlpha(char c){
        return (isWithinRange(SMALL_ALPHA_RANGE, (int)c)|| isWithinRange(CAP_ALPHA_RANGE, (int)c));
    }




    /**
     * check if given falls with the SMALL_ALPHA_RANGE
     *@param c a char to be checked
     *@return boolean if falls within range
    */
    public static boolean isSmallAlpha(char c){
        return (isWithinRange(SMALL_ALPHA_RANGE, (int)c));
    }




    /**
     * check if given char falls within CAP_ALPHA_RANGE
     * @param c a char to be checked
     * @return boolean true if falls wihtin range
    */
    public static boolean isCapAlpha(char c){
        return (isWithinRange(CAP_ALPHA_RANGE, (int)c));
    }





    /**
     * check if a value is within a given range
     * @param range an int array that has two element, the first
     * element is the min value, the second element is the max value
     * @param value an int to be checked 
     * @return boolean true if within range
    */
    private static boolean isWithinRange(int[] range, int value){
        if(value>=range[0] && value<=range[1]){
            return true;
        }
        else{
            return false;
        }
    }



}//end of class
