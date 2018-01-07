import com.thoughtworks.xstream.XStream;

public interface CarPark {
	/**
	 * 
	 * @return free ParkignSlot with smallest id
	 */
	public ParkingSlot getFreeParkingSlot();
	/**
	 * 
	 * @return
	 */
	public ParkingSlot[] getParkingSlots();
	/**
	 * 
	 * @return success
	 */
	public ParkingSlot[] setParkingSlots(ParkingSlot[] ps1);
	/**
	 * 
	 * @return
	 */
	public String saveState();
	/**
	 * 
	 * @return
	 */
	public static CarPark loadState(String xml) {
		XStream xstream = new XStream();
		return (CarPark) xstream.fromXML(xml);
	}
}
