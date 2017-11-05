import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTestSlotReservation {

	@Test
	public void setReservedParkingSlot_SimpleCall_SuccessTrue() {
		class TestCustomer implements Customer{

			ParkingSlot ps1 = null;
			
			@Override
			public boolean isCurrentlyParking() {
				return false;
			}
			@Override
			public boolean setCurrentlyParking(boolean b1) {
				return false;
			}
			@Override
			public boolean hasPaid() {
				return false;
			}
			@Override
			public boolean setPaid(boolean b1) {
				return false;
			}
			@Override
			public int getArrivalTime() {
				return 0;
			}
			@Override
			public boolean setArrivalTime(int i1) {
				return false;
			}
			@Override
			public ParkingSlot getCurrentSlot() {
				return null;
			}
			@Override
			public boolean setCurrentSlot(ParkingSlot ps1) {
				return false;
			}
			@Override
			public Rate getRate() {
				return null;
			}
			@Override
			public boolean setRate(Rate r1) {
				return false;
			}
			@Override
			public String getName() {
				return null;
			}
			@Override
			public boolean setName(String s1) {
				return false;
			}
			@Override
			public String getPassword() {
				return null;
			}
			@Override
			public boolean setPassword(String s1) {
				return false;
			}
			@Override
			public ParkingSlot getReservedParkingSlot() {
				return this.ps1;
			}
			@Override
			public boolean setReservedParkingSlot(ParkingSlot ps1) {
				if (this.ps1 != null) {
					return false;
				}
				this.ps1 = ps1;
				return true;
			}
			@Override
			public VehicleType getVehicleType() {
				return null;
			}
			@Override
			public boolean setVehicleType(VehicleType vt1) {
				return false;
			}
		}
		
		class SingleParkingSlot implements ParkingSlot {

			int id;
			SlotType sltype;
			
			@Override
			public int getId() {
				return this.id;
			}

			@Override
			public boolean setId(int id) {
				this.id = id;
				return true;
			}

			@Override
			public SlotType getSlotType() {
				return sltype;
			}

			@Override
			public boolean setSlotType(SlotType st1) {
				this.sltype = st1;
				return true;
			}

			@Override
			public UnregisteredCustomer getCostumer() {
				return null;
			}

			@Override
			public boolean setCostumer(UnregisteredCustomer us1) {
				return false;
			}
		}
		
		TestCustomer cs1 = new TestCustomer();
		SingleParkingSlot ps1 = new SingleParkingSlot();
		cs1.setReservedParkingSlot(ps1);
		
		assertEquals(ps1, cs1.getReservedParkingSlot());
		
	}
}
