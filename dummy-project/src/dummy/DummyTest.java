package dummy;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Simple tests to check your environment")
public class DummyTest implements WithAssertions {

   @DisplayName("This test must pass")
	@Test
	public void mustPass() {
		assertThat(1.0).isEqualTo(1.0);
	}

   @DisplayName("This test must fail")
	@Test
	public void mustFail() {
		assertThat(true).isEqualTo(false);
	}

}
