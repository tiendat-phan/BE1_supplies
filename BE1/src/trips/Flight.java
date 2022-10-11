package trips;

public class Flight {

    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;

    public Flight(String flightNumber, Airport depAirport, Airport arrAirport){
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrAirport;
        this.departureAirport = depAirport;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public Airport getDepartureAirport(){
        return this.departureAirport;
    }

    public Airport getArrivalAirport(){
        return this.arrivalAirport;
    }

    public String toString(){
        return this.flightNumber + " : " + this.departureAirport.getIata() + " - " + this.arrivalAirport.getIata();
    }

    public boolean isConnectedTo(Flight next ){
        
        return this.getArrivalAirport().isSameAs(next.getDepartureAirport());
    }
}
