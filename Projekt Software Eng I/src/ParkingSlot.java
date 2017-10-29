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
	public SlotType getSlotType();
	/**
	 * 
	 * @return success
	 */
	public boolean setSlotType(SlotType st1);
	/**
	 * 
	 * @return
	 */
	public UnregisteredCostumer getCostumer();
	/**
	 * 
	 * @return success
	 */
	public boolean setCostumer(UnregisteredCostumer us1);
}
