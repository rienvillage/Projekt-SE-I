import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	Customer uc = null; //Not implemented yet
	
	@Test
	public void hasPaid_SimpleCall_NotNull() {
		assertNotNull(uc.hasPaid());
	}

	@Test
	public void setPaid_AnyValue_SuccessTrue() {
		assertTrue(uc.setPaid(false));
		assertTrue(uc.setPaid(true));
	}

	@Test
	public void getArrivalTime_SimpleCall_NotNull() {
		assertNotNull(uc.getArrivalTime());
	}
	
	@Test
	public void getArrivalTime_SimpleCall_NotNegative() {
		if(uc.getArrivalTime() < 0) fail("Negative Value");
	}
	
	@Test
	public void setArrivalTime_NegativeValue_SuccessFalse() {

	}

	@Test
	public void getCurrentSlot_SimpleCall_NotNull() {
	
	}

	@Test
	public void setCurrentSlot_NullValue_SuccessFalse() {
	
	}
}
