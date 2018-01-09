import com.thoughtworks.xstream.XStream;

public class CustomerObject implements Customer {
	private boolean paid;
	private long arrivaltime;
	private long timetotal;
	
	public CustomerObject() {
		this.paid = false;
		this.arrivaltime = System.currentTimeMillis();
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
	public long getTimeTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long setTimeTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
