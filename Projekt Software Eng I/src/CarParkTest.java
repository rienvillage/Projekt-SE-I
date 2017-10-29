import static org.junit.Assert.*;

import org.junit.Test;

public class CarParkTest {
	CarPark cp = null;

	@Test
	public void getFreeParkingSlots_SimpleCall_NotNull() {
		assertNotNull(cp.getFreeParkingSlots());
	}
	
	@Test
	public void setParkingSlots_SimpleCall_NotNegative() {
		assertNotNull(cp.setParkingSlots(null));
	}

	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

}
