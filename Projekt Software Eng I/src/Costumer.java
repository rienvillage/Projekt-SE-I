
public interface Costumer extends UnregisteredCostumer {
	/**
	 * 
	 * @return
	 */
	public String getName();
	/**
	 * 
	 * 
	 */
	public void setName(String s1);
	/**
	 * 
	 * @return
	 */
	public String getPassword();
	/**
	 * 
	 * 
	 */
	public void setPassword(String s1);
	
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getReservedParkingSlot();
	/**
	 * 
	 * @return previously reserved Parking Slot (old value)
	 */
	public ParkingSlot setReservedParkingSlot(ParkingSlot ps1);
	/**
	 * 
	 * @return
	 */
	public VehicleType getVehicleType();
	/**
	 * 
	 * @return
	 */
	public VehicleType setVehicleType(VehicleType vt1);
}
