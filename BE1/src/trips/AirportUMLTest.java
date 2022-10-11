package trips;

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class AirportUMLTest {

   private TypeInfo typeInfo = TypeInfo.info(Airport.class);

   @Test
   @Order(1)
   public void hasExactlyAttributesFromUML() {
      assertThat(typeInfo).hasFieldCount(2);
      assertThat(typeInfo).declaresField("private String iata");
      assertThat(typeInfo).declaresField("private String name");
   }

   @Test
   @Order(2)
   public void hasExactlyConstructorsFromUML() {
      assertThat(typeInfo).hasConstructorCount(1);
      assertThat(typeInfo).declaresConstructor("public Airport(String, String)");
   }


   @Test
   @Order(3)
   public void hasExactlyMethodsFromUML() {
      assertThat(typeInfo).hasMethodCountBetween(3, 4);
      assertThat(typeInfo).declaresMethod("public String getName()");
      assertThat(typeInfo).declaresMethod("public String getIata()");
      assertThat(typeInfo).declaresMethod("public String toString()");
   }
}
