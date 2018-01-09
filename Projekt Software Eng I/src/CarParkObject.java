import com.thoughtworks.xstream.XStream;

public class CarParkObject implements CarPark {
	private ParkingSlot[] parkingslots;
	
	public CarParkObject(ParkingSlot[] parkingSlot) {
		this.parkingslots = parkingSlot;
	}

	@Override
	public ParkingSlot[] getParkingSlots() {
		return parkingslots;
	}

	@Override
	public ParkingSlot[] setParkingSlots(ParkingSlot[] ps1) {
		ParkingSlot[] ps = parkingslots;
		parkingslots = ps1;
		return ps;
	}
	@Override
	public String saveState() {
		XStream xstream = new XStream();
		String xml = xstream.toXML(this);
		return xml;
	}
	
	@Override
	public ParkingSlot getFreeParkingSlot() {
		for(int i = 0; i< this.getParkingSlots().length; i++) {
			if(this.getParkingSlots()[i].getCostumer() == null) return this.getParkingSlots()[i];
		}
		return null;
	}

	@Override
	public int getFreeParkingSlots() {
		int i = 0;
		for(int j = 0; j < this.getParkingSlots().length; j++) {
			if(this.getParkingSlots()[j].getCostumer() == null) i++;
		}
		return i;
	}

	@Override
	public int getTotalParkingSlots() {
		return this.getParkingSlots().length;
	}

	@Override
	public int getOccupiedParkingsSlots() {
		return this.getTotalParkingSlots() - this.getFreeParkingSlots();
	}
	
	public int findCustomer(Customer c) {
		for(ParkingSlot ps : this.getParkingSlots()) {
			if(ps.getCostumer().equals(c)) return ps.getId();
		}
		return -1;
	}
}
