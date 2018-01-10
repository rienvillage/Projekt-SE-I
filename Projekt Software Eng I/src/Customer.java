import com.thoughtworks.xstream.XStream;

public interface Customer {
	/**
	 * 
	 * @return 
	 */
	public boolean hasPaid();
	/**
	 * 
	 * @return success
	 */
	public boolean setPaid(boolean b1);
	/**
	 * 
	 * @return
	 */
	public long getTimeSincePaid();
	/**
	 * 
	 * @return
	 */
	public long setTimeSincePaid(long time);
	/**
	 * 
	 * @return
	 */
	public long getArrivalTime();
	/**
	 * 
	 * @return success
	 */
	public long setArrivalTime(long i1);
	/**
	 * 
	 * @return
	 */
	public VehicleType getVehicleType();
	/**
	 * 
	 * @param vt
	 * @return
	 */
	public VehicleType setVehicleType(VehicleType vt);
	/**
	 * 
	 * @return
	 */
	public String saveState();
	/**
	 * 
	 * @return
	 */
	public static Customer loadState(String xml) {
		XStream xstream = new XStream();
		return (Customer) xstream.fromXML(xml);
	}
}
