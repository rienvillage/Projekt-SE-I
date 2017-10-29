
public interface Customer extends UnregisteredCustomer {
	/**
	 * 
	 * @return
	 */
	public String getName();
	/**
	 * 
	 * @return success
	 */
	public boolean setName(String s1);
	/**
	 * 
	 * @return
	 */
	public String getPassword();
	/**
	 * 
	 * @return success
	 */
	public boolean setPassword(String s1);
	
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getReservedParkingSlot();
	/**
	 * 
	 * @return success
	 */
	public boolean setReservedParkingSlot(ParkingSlot ps1);
	/**
	 * 
	 * @return
	 */
	public VehicleType getVehicleType();
	/**
	 * 
	 * @return success
	 */
	public boolean setVehicleType(VehicleType vt1);
}
