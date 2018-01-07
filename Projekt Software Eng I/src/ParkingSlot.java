import com.thoughtworks.xstream.XStream;

public interface ParkingSlot {
	/**
	 * 
	 * @return
	 */
	public int getId();
	/**
	 * 
	 * @return success
	 */
	public int setId(int i1);
	/**
	 * 
	 * @return
	 */
	public Customer getCostumer();
	/**
	 * 
	 * @return success
	 */
	public Customer setCostumer(Customer us1);
	/**
	 * 
	 */
	public String saveState();
	/**
	 * @return
	 */
	public static ParkingSlot loadState(String xml) {
		XStream xstream = new XStream();
		return (ParkingSlot) xstream.fromXML(xml);
	}
}
