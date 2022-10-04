package airlines;

public class Main {

   public static void main(String[] args) {
      Airline af = new Airline("Air France", "AF");
      Airline ba = new Airline("British Airways", "BA");
      Airline lh = new Airline("Lufthansa", "LH");
      Airline ib = new Airline("Iberia", "IB");

      TravelAgency agency = new TravelAgency("Hello Travels");
      agency.addAirline(ba);
      agency.addAirline(af);
      agency.addAirline(lh);
      agency.addAirline(ib);
      agency.display();
      System.out.println(agency.getAirlineByIata("AF"));
      System.out.println(agency.getAirlineByIata("BA"));
      System.out.println(agency.getAirlineByIata("KK"));
   }
   
}
