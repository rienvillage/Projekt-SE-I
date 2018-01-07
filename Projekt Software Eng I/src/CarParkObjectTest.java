import static org.junit.Assert.*;

import org.junit.*;

public class CarParkObjectTest {

	private CarParkObject cpo;
	
	@Before
	public void init() {
		ParkingSlot[] parkingslots = new ParkingSlot[3];
		for(int i = 0; i < 3; i++) {
			//Erstellen leerer Parkplätze
			ParkingSlot ps = new ParkingSlotObject(i, null);
			parkingslots[i] = ps;
		}
		cpo = new CarParkObject(parkingslots);
	}
	@Test
	public void saveState_01() {
		String s = "<CarParkObject>\n" + 
				"  <parkingslots>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>0</id>\n" + 
				"    </ParkingSlotObject>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>1</id>\n" + 
				"    </ParkingSlotObject>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>2</id>\n" + 
				"    </ParkingSlotObject>\n" + 
				"  </parkingslots>\n" + 
				"</CarParkObject>";
		
		assertEquals(cpo.saveState(), s);
	}
	@Test
	public void saveState_02() {
		
		cpo.getParkingSlots()[0].setCostumer(new CustomerObject());
		
		String s = "<CarParkObject>\n" + 
				"  <parkingslots>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>0</id>\n" + 
				"      <customer class=\"CustomerObject\">\n" + 
				"        <paid>" + cpo.getParkingSlots()[0].getCostumer().hasPaid() + "</paid>\n" + 
				"        <arrivaltime>" + cpo.getParkingSlots()[0].getCostumer().getArrivalTime() + "</arrivaltime>\n" + 
				"      </customer>\n" + 
				"    </ParkingSlotObject>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>1</id>\n" + 
				"    </ParkingSlotObject>\n" + 
				"    <ParkingSlotObject>\n" + 
				"      <id>2</id>\n" + 
				"    </ParkingSlotObject>\n" + 
				"  </parkingslots>\n" + 
				"</CarParkObject>";
		
		assertEquals(cpo.saveState(), s);
	}
}
