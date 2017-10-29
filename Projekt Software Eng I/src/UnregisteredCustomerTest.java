import static org.junit.Assert.*;

import org.junit.Test;

public class UnregisteredCustomerTest {
	UnregisteredCustomer uc = null; //Not implemented yet
	
	@Test
	public void isCurrentlyParking_SimpleCall_NotNull() {
		assertNotNull(uc.isCurrentlyParking());
	}

	@Test
	public void setCurrentlyParking_AnyValue_SuccessTrue() {
		assertTrue(uc.setCurrentlyParking(false));
	}

	@Test
	public void hasPaid() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPaid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrivalTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetArrivalTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCurrentSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRate() {
		fail("Not yet implemented");
	}

}
