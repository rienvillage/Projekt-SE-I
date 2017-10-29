public interface ParkingSlot {
	/**
	 * 
	 * @return
	 */
	public int getId();
	/**
	 * 
	 * @return previously assigned Id
	 */
	public int setId();
	/**
	 * 
	 * @return
	 */
	public SlotType getSlotType();
	/**
	 * 
	 * @return
	 */
	public SlotType setSlotType();
	
	public UnregisteredCostumer getCostumer();
	public UnregisteredCostumer setCostumer();
}
