package trips;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class AirportBasicTest implements WithAssertions {

   @Test
   @Order(1)
   public void testConstructor() {
      Airport tls = new Airport("Toulouse Blagnac", "TLS");
      assertThat(tls).isNotNull();
      assertThat(tls).extracting("iata").isEqualTo("TLS");
      assertThat(tls).extracting("name").isEqualTo("Toulouse Blagnac");
      // if something goes wrong check that your parameters order in the
      // constructor is the same as the order of the UML diagram
   }

   @Test
   @Order(2)
   public void testGetters() {
      Airport tls = new Airport("Toulouse Blagnac", "TLS");
      assertThat(tls.getIata()).isEqualTo("TLS");
      assertThat(tls.getName()).isEqualTo("Toulouse Blagnac");
   }

   @Test
   @Order(3)
   public void testToString() {
      Airport tls = new Airport("Toulouse Blagnac", "TLS");
      assertThat(tls.toString()).containsSubsequence("Toulouse Blagnac", "(", "TLS", ")");
   }

}
