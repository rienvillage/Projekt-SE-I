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
		assertTrue(uc.setCurrentlyParking(true));
	}

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
		assertFalse(uc.setArrivalTime(-1));
	}

	@Test
	public void getCurrentSlot_SimpleCall_NotNull() {
		assertNotNull(uc.getCurrentSlot());
	}

	@Test
	public void setCurrentSlot_NullValue_SuccessFalse() {
		assertFalse(uc.setCurrentSlot(null));
	}

	@Test
	public void getRate_SimpleCall_NotNull() {
		assertNotNull(uc.getRate());
	}

	@Test
	public void setRate_AnyValue_SuccessTrue() {
		assertTrue(uc.setRate(Rate.NONE));
		assertTrue(uc.setRate(Rate.DAILY));
		assertTrue(uc.setRate(Rate.MONTHLY));
		assertTrue(uc.setRate(Rate.YEARLY));
	}

}
