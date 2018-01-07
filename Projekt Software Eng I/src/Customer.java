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
}
