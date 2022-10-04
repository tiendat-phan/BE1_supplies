package trips;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class TripBasicTest implements WithAssertions {

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
	public void testConstructor() {
		Trip trip = new Trip();
      assertThat(trip).isNotNull();
      assertThat(trip).extracting("flights").isNotNull();
      assertThat(trip).extracting("flights").asList().isEmpty();
	}
	
	@Test
   @Order(2)
	public void testAdd() {
		Trip trip = new Trip();
		trip.addFlight(f1);
      assertThat(trip).extracting("flights").asList().hasSize(1);
      assertThat(trip).extracting("flights").asList().contains(f1);
		trip.addFlight(f2);
      assertThat(trip).extracting("flights").asList().hasSize(2);
      // check presence, not order:
      assertThat(trip).extracting("flights").asList().contains(f1, f2);
      // check order:
      assertThat(trip).extracting("flights").asList().containsSequence(f1, f2);
	}
	
	@Test
   @Order(3)
	public void testToStringNoFlight() {
		Trip trip = new Trip();
      String representation = trip.toString().toLowerCase();
      assertThat(representation).contains("no"); // for "No flight yet"
	}

   @Test
   @Order(4)
	public void testToStringOneFlight() {
		Trip trip = new Trip();
		trip.addFlight(f1);
      String representation = trip.toString().toLowerCase();
      assertThat(representation).containsSubsequence("tls", "cdg", "direct"); 
		
		trip.addFlight(f2);
      representation = trip.toString().toLowerCase();
      assertThat(representation).containsSubsequence("tls", "rkv", "2", "flight"); 
	}

   @Test
   @Order(5)
	public void testToStringTwoFlights() {
		Trip trip = new Trip();
		trip.addFlight(f1);
		trip.addFlight(f2);
      String representation = trip.toString().toLowerCase();
      assertThat(representation).containsSubsequence("tls", "rkv", "2", "flight"); 
	}


}
