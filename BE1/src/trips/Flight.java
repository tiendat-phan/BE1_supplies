package trips;

public class Flight {

    private String flightNumber;
    private Airport depAirport;
    private Airport arrAirport;

    public Flight(String flightNumber, Airport depAirport, Airport arrAirport){
        this.flightNumber = flightNumber;
        this.arrAirport = arrAirport;
        this.depAirport = depAirport;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public Airport getDepartureAirport(){
        return this.depAirport;
    }

    public Airport getArrivalAirport(){
        return this.arrAirport;
    }

    public String toString(){
        return this.flightNumber + " : " + this.depAirport.getIata() + " - " + this.arrAirport.getIata();
    }

    public boolean isConnectedTo(Flight next ){
        
        return this.getArrivalAirport().isSameAs(next.getDepartureAirport());
    }
}
