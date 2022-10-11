package trips;

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.supaero.matchers.utils.TypeInfo;

public class TripPublicPrivateTest {

   private TypeInfo typeInfo = TypeInfo.info(Trip.class);

   @Test
   public void classShouldBePublic() {
      assertThat(typeInfo)
            .hasVisibility("public");
   }

   @CsvSource({
         "flights"
   })
   @ParameterizedTest
   public void attributesShouldBePrivate(String name) {
      assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   // @CsvSource({
   // })
   // @ParameterizedTest
   // public void constantsShouldBePublic(String name) {
   //    assertThat(typeInfo)
   //          .field(name).hasVisibility("public")
   //          .hasAllModifiersOf("final static");
   // }

   @CsvSource(delimiter = ';', value = {
         "Trip()"
   })
   @ParameterizedTest
   public void constructorsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @CsvSource(delimiter = ';', value = {
         "addFlight(Flight)",
         "toString()"
   })
   @ParameterizedTest
   public void methodsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .method(signature).hasVisibility("public");
   }
}
