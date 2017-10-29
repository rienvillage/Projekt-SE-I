import static org.junit.Assert.*;

import org.junit.Test;

public class CarParkTest {
	
	CarPark cp = null;
	ParkingSlot[] ps1 = null;

	@Test
	public void getFreeParkingSlots_SimpleCall_NotNull() {
		assertNotNull(cp.getFreeParkingSlots());
	}
	
	@Test
	public void getOccupiedParkingSlots_SimpleCall_NotNull() {
		assertNotNull(cp.getOccupiedParkingSlots());
	}

	@Test
	public void getParkingSlots_SimpleCall_NotNull() {
		assertNotNull(cp.getParkingSlots());
	}

	@Test
	public void setParkingSlots_SimpleCall_AssertTrue() {
		assertTrue(cp.setParkingSlots(ps1));
	}
	
}
