import com.thoughtworks.xstream.XStream;

public class ParkingSlotObject implements ParkingSlot {
	private int id;
	private Customer customer;
	
	public ParkingSlotObject(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public int setId(int i1) {
		int idold = this.getId();
		this.id = i1;
		return idold;
	}

	@Override
	public Customer getCostumer() {
		return this.customer;
	}

	@Override
	public Customer setCostumer(Customer us1) {
		Customer cold = this.getCostumer();
		this.customer = us1;
		return cold;
	}

	@Override
	public String saveState() {
		XStream xstream = new XStream();
		String xml = xstream.toXML(this);
		return xml;
	}
}
