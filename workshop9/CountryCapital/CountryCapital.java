//Student Name: Badal Sarkar
//Student ID:137226189

import java.util.HashMap;

public class CountryCapital {
    public static void main(String [] args){
        HashMap<String, String> capitalCities= new HashMap<String, String>();
        capitalCities.put("canada","Ottawa");
        capitalCities.put("china","Beijing");
        capitalCities.put("bangladesh","Dhaka");
        capitalCities.put("india","New Delhi");
        capitalCities.put("pakistan","Islamabad");
        capitalCities.put("russia","Moscow");
        capitalCities.put("turkey","Ankara");
        capitalCities.put("vietnam","Hanoi");
        capitalCities.put("united states","Washington D.C");
        capitalCities.put("thailand","Bangkok");
        capitalCities.put("sweden","Stockholm");
        capitalCities.put("spain","Madrid");
        capitalCities.put("qatar","Doha");
        capitalCities.put("poland","Warsaw");
        capitalCities.put("panama","Panama City");
        capitalCities.put("norway","Oslo");
        capitalCities.put("mexico","Mexico City");
        capitalCities.put("libya","Tripoli");
        capitalCities.put("kenya","Nairobi");
        capitalCities.put("italy","Rome");
        capitalCities.put("iran","Tehran");
        capitalCities.put("france","Paris");
        capitalCities.put("cuba","Havana");
        capitalCities.put("chile","Santiago");
        capitalCities.put("brazil","Brasilia");
        capitalCities.put("australia","Canberra");


        //get user input
        do{
            System.out.println("Enter a country to know the capital");
            String query= UserInteraction.getLine();
            query=(query.trim()).toLowerCase();
            if(capitalCities.containsKey(query)){
                System.out.println("The capital of "+query +" is " + capitalCities.get((query.trim()).toLowerCase()));
                System.out.println();
            }
            else{
                System.out.println("Country is not in the list");
                System.out.println();
            }

        }while(true);
    }
}
