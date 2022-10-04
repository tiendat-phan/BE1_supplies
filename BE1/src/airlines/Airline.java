package airlines;

public class Airline {
   private String name;
   private String iata;

   public Airline(String name, String iata) {
      this.name = name;
      this.iata = iata;
   }

   public String getName() {
      return this.name;
   }

   public String getIata() {
      return this.iata;
   }

   public String toString() {
      return this.name + "(" + this.iata + ")";
   }

}
