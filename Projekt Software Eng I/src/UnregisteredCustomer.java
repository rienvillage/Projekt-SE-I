public interface UnregisteredCustomer {
	
	/**
	 * 
	 * @return
	 */
	public boolean isCurrentlyParking();
	/**
	 * 
	 * @return success
	 */
	public boolean setCurrentlyParking(boolean b1);
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
	public int getArrivalTime();
	/**
	 * 
	 * @return success
	 */
	public boolean setArrivalTime(int i1);
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getCurrentSlot();
	/**
	 * 
	 * @return success
	 */
	public boolean setCurrentSlot(ParkingSlot ps1);
	/**
	 * 
	 * @return
	 */
	public Rate getRate();
	/**
	 * 
	 * @return success
	 */
	public boolean setRate(Rate r1);
}
