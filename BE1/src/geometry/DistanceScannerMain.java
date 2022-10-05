package geometry;

import java.util.Locale;
import java.util.Scanner;

public class DistanceScannerMain {
    public static void main(String[] args){
        

        Scanner scan = new Scanner(System.in);
        
        scan.useLocale(Locale.US);

        System.out.println("Input the P1 position (x y): ");
        
        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        Position p1 = new Position(x1,y1);
        System.out.println("Input the P2 position (x y): ");
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();
        Position p2 = new Position(x2,y2);

        System.out.println("Distance Euclide between P1 and P2: " + Position.distance(DistanceType.EUCLIDE, p1, p2));
        System.out.println("Distance Manhattan between P1 and P2: " + Position.distance(DistanceType.MANHATTAN, p1, p2));
        scan.close();

    }
}
