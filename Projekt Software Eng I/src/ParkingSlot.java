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
	public int setId(int i1);
	/**
	 * 
	 * @return
	 */
	public SlotType getSlotType();
	/**
	 * 
	 * @return
	 */
	public SlotType setSlotType(SlotType st1);
	/**
	 * 
	 * @return
	 */
	public UnregisteredCostumer getCostumer();
	/**
	 * 
	 * @return
	 */
	public UnregisteredCostumer setCostumer(UnregisteredCostumer us1);
}
