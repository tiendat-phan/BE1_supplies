package trips;

public class ValidationMain {
    public static void main(String[] args){
        Airport tls = new Airport("Toulouse Blagnac", "TLS");
		Airport cdg = new Airport("Roissy Charles de Gaulle", "CDG");
		Airport rkv = new Airport("Reykjavik", "RKV");
        Airport tdp = new Airport("TienDatPhan", "TDP");

        Flight f1 = new Flight("AF8888", cdg, tls);
		Flight f2 = new Flight("BB9999", tdp, rkv);
        Flight f3 = new Flight("CK1234",rkv,tdp);

        // System.out.println(tls.isSameAs(rkv));
        // System.out.println(tls.isSameAs(tls));
        //System.out.println(f1.isConnectedTo(f2));

        Trip a = new Trip();
        a.addFlight(f1);
        a.addFlight(f2);
        a.addFlight(f3);
        System.out.println(a.isValid());
    }
}
