package airlines;

import java.util.ArrayList;

public class TravelAgency {

   private String name;
   private ArrayList<Airline> suppliers;

   public TravelAgency(String name) {
      this.name = name;
      suppliers = new ArrayList<>();
   }

   public void addAirline(Airline airline) {
      suppliers.add(airline);
   }

   public Airline getAirlineByIata(String iata) {
      int num = suppliers.size();
      for(int i = 0; i < num; i++) {

         if(suppliers.get(i).getIata() == iata ){
            return suppliers.get(i);
            
         }
      }
      return null;

      
   }

   public void display() {
      System.out.println(this.name);
      System.out.println("Suppliers:");
      int num = suppliers.size();
      for(int i = 0; i < num;i++){
         suppliers.get(i).toString();
      }
   }
}
