import static org.junit.Assert.*;

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
	public void setId_negativeInput_SuccessFalse() {
		assertFalse(ps.setId(-1));
	}

	@Test
	public void getSlotType_SimpleCall_NotNull() {
		assertNotNull(ps.getSlotType());
	}

	@Test
	public void setSlotType_NullInput_SuccessFalse() {
		assertFalse(ps.setSlotType(null));
	}

	@Test
	public void getCostumer_SimpleCall_NotNull() {
		assertNotNull(ps.getCostumer());
	}

	@Test
	public void setCostumer_NullInput_SuccessFalse() {
		assertNotNull(ps.setCostumer(null));
	}

}
