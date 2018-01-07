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
}
