package trips;

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class FlightUMLTest {

   private TypeInfo typeInfo = TypeInfo.info(Flight.class);

   @Test
   @Order(1)
   public void hasExactlyAttributesFromUML() {
      assertThat(typeInfo).hasFieldCount(3);
      assertThat(typeInfo).declaresField("private Airport departureAirport");
      assertThat(typeInfo).declaresField("private Airport arrivalAirport");
      assertThat(typeInfo).declaresField("private String flightNumber");
   }

   @Test
   @Order(2)
   public void hasExactlyConstructorsFromUML() {
      assertThat(typeInfo).hasConstructorCount(1);
      assertThat(typeInfo).declaresConstructor("public Flight(String, Airport, Airport)");
   }


   @Test
   @Order(3)
   public void hasExactlyMethodsFromUML() {
      assertThat(typeInfo).hasMethodCountBetween(4, 5);
      assertThat(typeInfo).declaresMethod("public String getFlightNumber()");
      assertThat(typeInfo).declaresMethod("public Airport getDepartureAirport()");
      assertThat(typeInfo).declaresMethod("public Airport getArrivalAirport()");
      assertThat(typeInfo).declaresMethod("public String toString()");
   }
}
