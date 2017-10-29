public interface CarPark {
	/**
	 * 
	 * @return amount of free parking slots in car park
	 */
	public ParkingSlot[] getFreeParkingSlots();
	/**
	 * 
	 * @return amount of occupied parking slots in car park
	 */
	public ParkingSlot[] getOccupiedParkingSlots();
	/**
	 * 
	 * @return
	 */
	public ParkingSlot[] getParkingSlots();
	/**
	 * 
	 * @return success
	 */
	public boolean setParkingSlots(ParkingSlot[] ps1);
}
