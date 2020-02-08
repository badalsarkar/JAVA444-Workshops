
//student Name: Badal Sarkar
//Student Id: 137226189
//


//this class maintains and  supplies interest rates
public final class RateChart{
    private static double rateChart[][]={{.5,0.0099},{1,0.0195},{2,0.0295},{4,0.0395},{5,0.0495}};

    //methods
    public static double getRate(double tenure){
        for(int i=0; i<rateChart.length; i++){
            if(rateChart[i][0]==tenure)
                return rateChart[i][1];
        }
        return 0;
    }

        
}
