package trips;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class FlightBasicTest implements WithAssertions {

	private Airport tls;
	private Airport cdg;

	@BeforeEach
	public void setUp() throws Exception {
		tls = new Airport("Toulouse Blagnac", "TLS");
		cdg = new Airport("Roissy Charles de Gaulle", "CDG");
	}

	@Test
   @Order(1)
	public void testConstructor() {
		Flight flight = new Flight("AF1234", tls, cdg);
      assertThat(flight).isNotNull();
      assertThat(flight).extracting("flightNumber").isEqualTo("AF1234");
      assertThat(flight).extracting("departureAirport").isEqualTo(tls);
      assertThat(flight).extracting("arrivalAirport").isEqualTo(cdg);
	}
	
	@Test
   @Order(2)
	public void testGetters() {
		Flight flight = new Flight("AF1234", tls, cdg);
		assertThat(flight.getFlightNumber()).isEqualTo("AF1234");
		assertThat(flight.getDepartureAirport()).isEqualTo(tls);
		assertThat(flight.getArrivalAirport()).isEqualTo(cdg);
	}
	
	@Test
   @Order(3)
	public void testToString() {
		Flight flight = new Flight("AF1234", tls, cdg);
      assertThat(flight.toString()).containsSubsequence("AF1234", "TLS", "CDG");
	}

}
