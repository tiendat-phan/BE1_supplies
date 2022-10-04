package trips;

public class TripMain {
    public static void main(String[] args){
        Airport tls = new Airport("Toulouse Blagnac", "TLS");
        
        System.out.println(tls.toString());

        Airport cdg = new Airport("Roissy Charles de Gaulle", "CDG");
        Airport rkv = new Airport("Reykjavik", "RKV");
        Flight a = new Flight("AF1234", tls, cdg);
        Flight a1 = new Flight("AF1234",cdg, rkv);
        System.out.println(a.toString());

        Trip b = new Trip();
        b.addFlight(a);
        b.addFlight(a1);

        System.out.println(b.toString());

    }
}
