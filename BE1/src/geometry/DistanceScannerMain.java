package geometry;

import java.util.Locale;
import java.util.Scanner;

public class DistanceScannerMain {
    public static void main(String[] args){
        // Position p1 = new Position(2,3);
        // Position p2 = new Position(-1,-1);
        // // System.out.println("Distance euclide between p1 and p2: " + Position.euclide(p1,p2));
        // // System.out.println("Distance manhattan between p1 and p2: " + Position.manhattan(p1,p2));

        
        // System.out.println(Position.distance(DistanceType.MANHATTAN,p1,p2));
        // System.out.println(Position.distance(DistanceType.EUCLIDE,p1,p2));

        Scanner scan = new Scanner("Position (x,y): ");
        System.out.println("Scanner String: \n"
                           + scan.nextLine());

        scan.useLocale(Locale.US);

        System.out.println("Local: " + scan.locale());

        scan.close();

    }
}
