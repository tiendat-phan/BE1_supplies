package trips;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class ValidationTest implements WithAssertions {

	private Airport tls;
	private Airport cdg;
	private Airport rkv;
	private Flight f1;
	private Flight f2;

	@BeforeEach
	public void setUp() throws Exception {
		tls = new Airport("Toulouse Blagnac", "TLS");
		cdg = new Airport("Roissy Charles de Gaulle", "CDG");
		rkv = new Airport("Reykjavik", "RKV");
		f1 = new Flight("AF8888", tls, cdg);
		f2 = new Flight("BB9999", cdg, rkv);
	}

   @Test
   @Order(1)
	public void isSameAs_shouldUseIataOnly() {
      assertThat(tls.isSameAs(tls)).isTrue();
      assertThat(tls.isSameAs(cdg)).isFalse();

      Airport tls1 = new Airport("Toto", "TLS");
      assertThat(tls.isSameAs(tls1)).isTrue();
	}
	
   @Test
   @Order(2) // utilise Equal functions 
	public void isSameAs_shouldUseEquals() {
      Airport tls2 = new Airport("Toto", new String("TLS"));
      assertThat(tls.isSameAs(tls2)).isTrue();
	}
	
	@Test
   @Order(3)
	public void isConnectedTo_shouldWork() {
      assertThat(f1.isConnectedTo(f2)).isTrue();
      assertThat(f1.isConnectedTo(f1)).isFalse();
      assertThat(f2.isConnectedTo(f1)).isFalse();
	}

   	
	@Test
   @Order(3)
	public void isConnectedTo_shouldUseLogicalEquality() {
      Airport cdg2 = new Airport("Paris", "CDG");
      Flight f1back = new Flight("FFF111", cdg2, tls);  // cdg is same as cdg2
      assertThat(f1.isConnectedTo(f1back)).isTrue();
	}

   @Test
   @Order(4)
	public void isValid_shouldBeFalseForEmptyTrip() {
		Trip trip = new Trip();
      assertThat(trip.isValid()).isFalse();
	}

   @Test
   @Order(5)
   public void isValid_shouldTrueForDirectFlights() {
      Trip trip = new Trip();
      trip.addFlight(f1);
      assertThat(trip.isValid()).isTrue();

      trip = new Trip();
      trip.addFlight(f2);
      assertThat(trip.isValid()).isTrue();
   }

   @Test
   @Order(6)
	public void isValid_forConnectedTrips() {
		Trip trip = new Trip();
		trip.addFlight(f1);
		trip.addFlight(f2);
      assertThat(trip.isValid()).isTrue();

      trip = new Trip();
		trip.addFlight(f2);
		trip.addFlight(f1); // cannot do f2 then f1
      assertThat(trip.isValid()).isFalse();

      trip = new Trip();
		trip.addFlight(f1);
		trip.addFlight(f1); // cannot do f1 then f1 again
      assertThat(trip.isValid()).isFalse();
	}

}
