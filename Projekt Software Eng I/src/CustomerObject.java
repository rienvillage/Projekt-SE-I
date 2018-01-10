import com.thoughtworks.xstream.XStream;

public class CustomerObject implements Customer {
	private boolean paid;
	private long arrivaltime;
	private long timepaid;
	private VehicleType vt;
	
	public CustomerObject() {
		this.paid = false;
		this.arrivaltime = System.currentTimeMillis();
		this.timepaid = -1;
		this.vt = VehicleType.getInstance("PKW");
	}
	public CustomerObject(VehicleType vt) {
		this.paid = false;
		this.arrivaltime = System.currentTimeMillis();
		this.timepaid = -1;
		this.vt = vt;
	}
	
	@Override
	public boolean hasPaid() {
		return this.paid;
	}

	@Override
	public boolean setPaid(boolean b1) {
		boolean p = this.hasPaid();
		this.paid = b1;
		return p;
	}
	@Override
	public long getArrivalTime() {
		return this.arrivaltime;
	}

	@Override
	public long setArrivalTime(long i1) {
		long l = this.getArrivalTime();
		this.arrivaltime = i1;
		return l;
	}
	@Override
	public String saveState() {
		XStream xstream = new XStream();
		String xml = xstream.toXML(this);
		return xml;
		
	}
	@Override
	public long getTimeSincePaid() {
		return this.timepaid;
	}
	@Override
	public long setTimeSincePaid(long time) {
		long l = this.timepaid;
		this.timepaid = time;
		return l;
	}
	@Override
	public VehicleType getVehicleType() {
		return this.vt;
	}
	@Override
	public VehicleType setVehicleType(VehicleType vt) {
		VehicleType old = this.getVehicleType();
		this.vt = vt;
		return old;
	}
}
