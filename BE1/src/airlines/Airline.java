package airlines;

public class Airline {
   private String name;
   private String iata;

   public Airline(String name, String iata) {
      this.name = name;
      this.iata = iata;
   }

   public String getName() {
      return name;
   }

   public String getIata() {
      return iata;
   }

   public String toString() {
      return name + "(" + iata + ")";
   }

}
