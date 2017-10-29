public interface UnregisteredCostumer {
	
	/**
	 * 
	 * @return
	 */
	public boolean isCurrentlyParking();
	/**
	 * 
	 */
	public void setCurrentlyParking();
	/**
	 * 
	 * @return 
	 */
	public boolean hasPaid();
	/**
	 * 
	 */
	public void setPaid();
	/**
	 * 
	 * @return
	 */
	public int getArrivalTime();
	/**
	 * 
	 */
	public void setArrivalTime();
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getCurrentSlot();
	/**
	 * 
	 */
	public void setCurrentSlot();
	/**
	 * 
	 * @return
	 */
	public Rate getRate();
	/**
	 * 
	 * @return previous Rate
	 */
	public Rate setRate();
}
