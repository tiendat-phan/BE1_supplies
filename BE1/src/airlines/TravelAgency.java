package airlines;


import java.util.HashMap;
import java.util.TreeMap;

public class TravelAgency {

   private String name;
   
   private TreeMap<String, Airline> suppliers;

   public TravelAgency(String name) {
      this.name = name;
      this.suppliers = new TreeMap<>();

   }

   public void addAirline(Airline airline) {
      this.suppliers.put(airline.getIata(),airline);
   }

   public Airline getAirlineByIata(String iata) {
     return this.suppliers.get(iata);

      
   }
   
   public void display() {
      System.out.println(this.name);
      System.out.println("Suppliers:");
      
      System.out.println(this.suppliers.toString());
   }
}
