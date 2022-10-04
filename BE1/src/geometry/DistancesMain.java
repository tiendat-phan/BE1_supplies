package geometry;

public class DistancesMain {
    static public void main(String[] args){
        Position p1 = new Position(2,3);
        Position p2 = new Position(-1,-1);
        // System.out.println("Distance euclide between p1 and p2: " + Position.euclide(p1,p2));
        // System.out.println("Distance manhattan between p1 and p2: " + Position.manhattan(p1,p2));

        
        System.out.println(Position.distance(DistanceType.MANHATTAN,p1,p2));
        System.out.println(Position.distance(DistanceType.EUCLIDE,p1,p2));
    }
}
