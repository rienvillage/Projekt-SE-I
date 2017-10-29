import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.Test;

public class ParkingSlotTest {
	ParkingSlot ps = null; //Class not implemented yet...
	
	@Test
	public void getId_SimpleCall_NotNull() {
		assertNotNull(ps.getId());
	}
	
	@Test
	public void getId_SimpleCall_NotNegative() {
		if(ps.getId() < 0) fail("Id is a negative value");
	}
	
	@Test
	public void setId_negativeInput_NoException() {
		
	}

	@Test
	public void testGetSlotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSlotType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCostumer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCostumer() {
		fail("Not yet implemented");
	}

}
