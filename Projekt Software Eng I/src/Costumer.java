
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
	public void setName();
	/**
	 * 
	 * @return
	 */
	public String getPassword();
	/**
	 * 
	 * 
	 */
	public void setPassword();
	
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getReservedParkingSlot();
	/**
	 * 
	 * @return previously reserved Parking Slot (old value)
	 */
	public ParkingSlot setReservedParkingSlot();
	/**
	 * 
	 * @return
	 */
	public VehicleType getVehicleType();
	/**
	 * 
	 * @return
	 */
	public VehicleType setVehicleType();
}
