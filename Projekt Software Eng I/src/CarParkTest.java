
import static org.junit.Assert.*;

import org.junit.Test;

public class CarParkTest {
	
	CarPark cp = null; //Not implemented yet
	ParkingSlot[] ps1 = null; //Not implemented yet

<<<<<<< HEAD
=======
	@Test
	public void getFreeParkingSlots_SimpleCall_NotNull() {
		//assertNotNull(cp.getFreeParkingSlots());
	}
	
	@Test
	public void getOccupiedParkingSlots_SimpleCall_NotNull() {
		//assertNotNull(cp.getOccupiedParkingSlots());
	}
>>>>>>> branch 'master' of https://github.com/rienvillage/Projekt-SE-I.git

	@Test
	public void getParkingSlots_SimpleCall_NotNull() {
		assertNotNull(cp.getParkingSlots());
	}

	@Test
	public void setParkingSlots_SimpleCall_SuccessTrue() {
		//assertTrue(cp.setParkingSlots(ps1));
	}
	
	@Test
	public void setParkingSlots_SimpleCall_SuccessFalse() {
		//assertTrue(cp.setParkingSlots(null));
	}
}
