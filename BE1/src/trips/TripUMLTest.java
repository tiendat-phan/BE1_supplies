package trips;

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class TripUMLTest {

   private TypeInfo typeInfo = TypeInfo.info(Trip.class);

   @Test
   @Order(1)
   public void hasExactlyAttributesFromUML() {
      assertThat(typeInfo).hasFieldCount(1);
      assertThat(typeInfo.getField("flights").field).hasTypeSubtyping(List.class);
      assertThat(typeInfo).declaresField("private ArrayList<Flight> flights");
   }

   @Test
   @Order(2)
   public void hasExactlyConstructorsFromUML() {
      assertThat(typeInfo).hasConstructorCount(1);
      assertThat(typeInfo).declaresConstructor("public Trip()");
   }


   @Test
   @Order(3)
   public void hasExactlyMethodsFromUML() {
      assertThat(typeInfo).hasMethodCountBetween(2, 3);
      assertThat(typeInfo).declaresMethod("public void addFlight(Flight)");
      assertThat(typeInfo).declaresMethod("public String toString()");
   }
}
