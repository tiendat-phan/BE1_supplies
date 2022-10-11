package geometry;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.supaero.matchers.assertions.TypeAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class DistanceTypeTest implements WithAssertions {

   @Test
   public void UMLWellInterpreted() {
      TypeInfo typeInfo = TypeInfo.info(Position.class);
      TypeAssertions.assertThat(typeInfo).declaresMethod("static public double distance(DistanceType, Position, Position)");
   }

   @Test
   @Order(1)
   public void DistanceType_isAnEnum() {
      TypeInfo typeInfo = TypeInfo.info(DistanceType.class);
      TypeAssertions.assertThat(typeInfo).hasNature("enum");
   }

   @CsvSource({
         "0, 0, 3, 4, 5",
         "0, 0, -3, 4, 5",
         "0, 0, 3, -4, 5",
         "-1, -1, -1, -1, 0",
   })
   @ParameterizedTest
   @Order(2)
   public void testEuclide(double x1, double y1, double x2, double y2, double expectedDistance) {
      Position p1 = new Position(x1, y1);
      Position p2 = new Position(x2, y2);
      assertThat(Position.distance(DistanceType.values()[0], p1, p2)).isEqualTo(expectedDistance, within(1e-9));
   }

   @CsvSource({
         "0, 0, 3, 4, 7",
         "0, 0, -3, 4, 7",
         "-2, -2, 1, -6, 7",
         "-1, -1, -1, -1, 0",
   })
   @ParameterizedTest
   @Order(3)
   public void testManhattan(double x1, double y1, double x2, double y2, double expectedDistance) {
      Position p1 = new Position(x1, y1);
      Position p2 = new Position(x2, y2);
      assertThat(Position.distance(DistanceType.values()[1], p1, p2)).isEqualTo(expectedDistance, within(1e-9));
   }
}
