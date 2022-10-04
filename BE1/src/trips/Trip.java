package trips;

import java.util.ArrayList;

public class Trip {
    private ArrayList<Flight> flights;

    public Trip(){
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flt){
        flights.add(flt);
    }

    public String toString(){
        int num = flights.size();
        if(num == 0){
            return " No flight yet";
        }
        else{
            if(flights.size() == 1){
                return flights.get(0).getDepartureAirport().getIata() + " - " + flights.get(0).getArrivalAirport().getIata() + "(direct)";
            }
            else{
                
                return flights.get(0).getDepartureAirport().getIata() + " - " + flights.get(num -1).getArrivalAirport().getIata() +" "+ num + " (flights)";
            }
        }
    }

    public boolean isValid(){
        int num = flights.size();
        if(num == 1){
            return true;
        }
       else if(num == 0){
        return false;
       }
       else{
        for(int i=0 ; i < num -1 ;i++){
            if(!flights.get(i).isConnectedTo(flights.get(i+1))){
                return false;
            }
            
        }
        return true;
       }
    }
}
