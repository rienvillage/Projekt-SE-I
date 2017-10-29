import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	Customer c = null; //not implemented yet...
	
	@Test
	public void testGetName() {
		assertNotNull(c.getName());
	}

	@Test
	public void testSetName() {
		assertFalse(c.setName(null));
	}

	@Test
	public void testGetPassword() {
		assertNotNull(c.getPassword());
	}

	@Test
	public void testSetPassword() {
		assertFalse(c.setPassword(null));
	}

	@Test
	public void testGetReservedParkingSlot() {
		assertNotNull(c.getReservedParkingSlot());
	}

	@Test
	public void testSetReservedParkingSlot() {
		assertFalse(c.setReservedParkingSlot(null));
	}

	@Test
	public void testGetVehicleType() {
		assertNotNull(c.getVehicleType());
	}

	@Test
	public void testSetVehicleType() {
		assertFalse(c.setVehicleType(null));
	}

}
