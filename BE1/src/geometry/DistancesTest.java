package geometry;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DistancesTest implements WithAssertions {

   @CsvSource({
         "0, 0, 3, 4, 5",
         "0, 0, -3, 4, 5",
         "0, 0, 3, -4, 5",
         "-1, -1, -1, -1, 0",
   })
   @ParameterizedTest
   public void testEuclide(double x1, double y1, double x2, double y2, double expectedDistance) {
      Position p1 = new Position(x1, y1);
      Position p2 = new Position(x2, y2);
      assertThat(Position.euclide(p1, p2)).isEqualTo(expectedDistance, within(1e-9));
   }

   @CsvSource({
         "0, 0, 3, 4, 7",
         "0, 0, -3, 4, 7",
         "-2, -2, 1, -6, 7",
         "-1, -1, -1, -1, 0",
   })
   @ParameterizedTest
   public void testManhattan(double x1, double y1, double x2, double y2, double expectedDistance) {
      Position p1 = new Position(x1, y1);
      Position p2 = new Position(x2, y2);
      assertThat(Position.manhattan(p1, p2)).isEqualTo(expectedDistance, within(1e-9));
   }
}
