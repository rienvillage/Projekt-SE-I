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
	public boolean setId(int i1);
	/**
	 * 
	 * @return
	 */
	public UnregisteredCustomer getCostumer();
	/**
	 * 
	 * @return success
	 */
	public boolean setCostumer(UnregisteredCustomer us1);
}
