package airlines;

import java.util.TreeMap;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import fr.supaero.matchers.utils.TypeInfo;
import fr.supaero.matchers.assertions.TypeAssertions;

@TestMethodOrder(OrderAnnotation.class)
public class TravelAgencyTest implements WithAssertions {

   private Airline af;
   private Airline ba;
   private Airline lh;
   private Airline ib;

   @BeforeEach
   public void setUp() throws Exception {
      af = new Airline("Air France", "AF");
      ba = new Airline("British Airways", "BA");
      lh = new Airline("Lufthansa", "LH");
      ib = new Airline("Iberia", "IB");
   }

   @Test
   @Order(1)
   public void suppliers_shouldBeDeclaredAsATreeMap() {
      TypeInfo typeInfo = TypeInfo.info(TravelAgency.class);
      TypeAssertions.assertThat(typeInfo).hasFieldCount(2);
      TypeAssertions.assertThat(typeInfo).hasField("suppliers");
      TypeAssertions.assertThat(typeInfo.getField("suppliers").field).hasType("TreeMap<String, Airline>");
      TypeAssertions.assertThat(typeInfo.getField("suppliers").field).hasExactlyModifiers("private");
   }

   @Test
   @Order(2)
   public void suppliers_shouldBeDeclaredAndInitialized() {
      TravelAgency agency = new TravelAgency("Hello Travels");
      assertThat(agency).extracting("suppliers").isNotNull();
   }

   @Test
   @Order(3)
   public void addGet_shouldBeConsistent() {
      TravelAgency agency = new TravelAgency("Hello Travels");
      assertThat(agency.getAirlineByIata("AF")).isNotEqualTo(af);
      agency.addAirline(af);
      assertThat(agency.getAirlineByIata("AF")).isEqualTo(af);
      agency.addAirline(ba);
      assertThat(agency.getAirlineByIata("BA")).isEqualTo(ba);
      assertThat(agency.getAirlineByIata("AF")).isEqualTo(af);
      agency.addAirline(lh);
      agency.addAirline(ib);
      assertThat(agency.getAirlineByIata("LH")).isEqualTo(lh);
      assertThat(agency.getAirlineByIata("IB")).isEqualTo(ib);
      assertThat(agency.getAirlineByIata("AF")).isEqualTo(af);
      assertThat(agency.getAirlineByIata("BA")).isEqualTo(ba);
   }

   @Test
   @Order(4)
   public void display_shouldUseIATAOrder() throws Exception {
      TravelAgency agency = new TravelAgency("Hello Travels");
      agency.addAirline(lh);
      agency.addAirline(ba);
      agency.addAirline(af);
      agency.addAirline(ib);

      String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
         agency.display();
      });

      assertThat(displayedText).containsSubsequence("AF", "BA", "IB", "LH");
   }
}
