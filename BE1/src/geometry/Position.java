package geometry;

/**
 * Simplistic class representing Cartesian 2D positions.
 */
public class Position {
   /** Abscissa */
   private double x;
   /** Ordinate */
   private double y;

   /**
    * Initialize a newly created position to (0, 0) coordinates
    */
   public Position() {
      this.x = 0;
      this.y = 0;
   }

   /**
    * Initialize a newly created position to the specified coordinates
    * 
    * @param x0 Initial abscissa
    * @param y0 Initial ordinate
    */
   public Position(double x0, double y0) {
      this.x = x0;
      this.y = y0;
   }

   /**
    * Duplicates an existing position
    * 
    * @param p0 Existing position
    */
   public Position(Position p0) {
      this.x = p0.x;
      this.y = p0.y;
   }

   /**
    * Sets current position to the specified coordinates
    * 
    * @param nextX Target abscissa
    * @param nextY Target ordinate
    */
   public void moveTo(double nextX, double nextY) {
      this.x = nextX;
      this.y = nextX;
   }

   /**
    * Sets current position to the same coordinates as another position
    * 
    * @param other Target position
    */
   public void moveTo(Position other) {
      this.x = other.x;
      this.x = other.y;
   }

   /**
    * Euclidean distance of current position to origin (0, 0)
    * 
    * @return Euclidean distance to origin
    */
   public double distanceToOrigin() {
      return Math.sqrt(this.x * this.x + this.y * this.y);
   }

   /**
    * Create a position halfway between current position and origin (0, 0)
    * 
    * @return Reference to newly created midpoint
    */
   public Position halfwayToOrigin() {
      return new Position(this.x / 2, this.y / 2);
   }

   /**
    * Logical equality between Positions
    * 
    * @param position Position to test
    * @return Do this and position have the same x and y values?
    */
   public boolean equals(Position position) {
      if (position == null)
         return false;
      if (position == this) // same object referenced?
         return true;
      // different objects, same content?
      return this.x == position.x && this.y == position.y;
   }

   /**
    * Displays current position on the console, with format "(x, y)"
    */
   public void display() {
      System.out.println(this.toString());
   }

   /**
    * Returns current position content as string "(x,y)"
    */
   public String toString() {
      return ("(" + this.x + "," + this.y + ")");
   }

   public static double euclide(Position p1, Position p2){
      double delta_x = (p1.x - p2.x)*(p1.x - p2.x);
      double delta_y = (p1.y - p2.y)*(p1.y - p2.y);

      return Math.sqrt(delta_x + delta_y);
   }

   public static double manhattan(Position p1, Position p2){
      return Math.abs(p2.x - p1.x ) + Math.abs(p2.y - p1.y);
   }

   static public double distance(DistanceType type , Position p1, Position p2){

         switch(type){
            case EUCLIDE:
               return Position.euclide(p1, p2);
            case MANHATTAN:
               return Position.manhattan(p1, p2);
            default:
               return 0;
         }

   }
}
