public interface UnregisteredCostumer {
	
	/**
	 * 
	 * @return
	 */
	public boolean isCurrentlyParking();
	/**
	 * 
	 */
	public void setCurrentlyParking(boolean b1);
	/**
	 * 
	 * @return 
	 */
	public boolean hasPaid();
	/**
	 * 
	 */
	public void setPaid(boolean b1);
	/**
	 * 
	 * @return
	 */
	public int getArrivalTime();
	/**
	 * 
	 */
	public void setArrivalTime(int i1);
	/**
	 * 
	 * @return
	 */
	public ParkingSlot getCurrentSlot();
	/**
	 * 
	 */
	public void setCurrentSlot(ParkingSlot ps1);
	/**
	 * 
	 * @return
	 */
	public Rate getRate();
	/**
	 * 
	 * @return previous Rate
	 */
	public Rate setRate(Rate r1);
}
