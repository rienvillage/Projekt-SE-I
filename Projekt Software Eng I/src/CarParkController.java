import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class CarParkController {

	private CarParkView view;
	private CarParkObject model;
	private JTable table;
	private JTextArea textArea;
	private JComboBox<String> box;
	
	public CarParkController() {
		this.view = new CarParkView();
		
		try {
			model = (CarParkObject) CarPark.loadState(CarPark.readFromFile("data"));
			view.setParkplatzSize("Ein Parkhaus mit " + model.getParkingSlots().length + " Plaetzen wurde geladen.");
		} catch(NullPointerException e) {
			ParkingSlot[] parkingslots = new ParkingSlot[Config.PH_SIZE];
			for(int i = 0; i < Config.PH_SIZE; i++) {
				ParkingSlot ps = new ParkingSlotObject(i, null);
				parkingslots[i] = ps;
			
				model = new CarParkObject(parkingslots);
				view.setParkplatzSize("Ein Parkhaus mit " + Config.PH_SIZE + " Plaetzen wurde erstellt.");
			}
		}
		
		view.addParkLabels();
		view.addConsoleText();
		view.addEinfahrtButton();
		
		box = view.addComboBox();
		
		table = view.addTable();
		textArea = view.addTextArea();
		
		view.addResetButton();
		
		ButtonColumn buttonColumn = new ButtonColumn(table, this.getTableAction(), 4);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		//this.initTable();
		
		view.addUmsatzLabel();
		
		addListener();
		
		update();
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	private void addListener() {

		this.view.setEinfahrtListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(model.getFreeParkingSlots() <= 0) {
					view.setTextField("Keine freien Parkplaetze verfuegbar.");
					return;
				}
				
				Customer c = new CustomerObject(VehicleType.getInstance((String) box.getSelectedItem()));
				
				int slotId = model.getFreeParkingSlot().getId();
				model.getParkingSlots()[slotId].setCustomer(c);
				
				view.setTextField("Ein " + box.getSelectedItem() + " hat Parkplatz " + slotId + " belegt.");
				
				update();		
			}
			
		});
		
		this.view.setReset(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CarPark.delFile("data");
				for(int i = 0; i < Config.PH_SIZE; i++) model.getParkingSlot(i).setCustomer(null);
				view.setTextField("Das Parkhaus wurde resettet.");
				update();
			}
		});
	}
	
	public CarPark getCarParkObject() {
		return this.model;
	}
	public CarParkView getCarParkView() {
		return this.view;
	}
	protected void update() {
		for(int i = 0; i < Config.PH_SIZE; i++) {
			ParkingSlot ps = model.getParkingSlots()[i];
			if(ps.getCustomer() == null) {
				table.setValueAt("frei", i, 0);
				table.setValueAt("-", i, 1);
				table.setValueAt("-", i, 2);
				table.setValueAt("false", i, 2);
				continue;
			} else {
				if(ps.getCustomer().hasPaid() && (System.currentTimeMillis() - ps.getCustomer().getTimeSincePaid()) > Config.TIME_TO_LEAVE) {
					ps.getCustomer().setArrivalTime(ps.getCustomer().getTimeSincePaid());
					ps.getCustomer().setPaid(false);
				}
				
				table.setValueAt(i, i, 0);
				table.setValueAt(ps.getCustomer().getVehicleType().getName(), i, 1);
				table.setValueAt(this.calcTimeString(System.currentTimeMillis() - ps.getCustomer().getArrivalTime()), i, 2);
				table.setValueAt(ps.getCustomer().hasPaid(), i, 3);
			}
		}
		
		view.setFreieParkplaetze("" + model.getFreeParkingSlots());
		view.setParkplaetze("" + model.getTotalParkingSlots());
		view.setBelegteParkplaetze("" + model.getOccupiedParkingsSlots());
		
		view.setUmsatz("" + model.getTotalProfit());
	}
	private String calcTimeString(long millis) {
	    if(millis < 0) return null;

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);

        sb.append(hours);
        sb.append(" h ");
        sb.append(minutes);
        sb.append(" m ");
        sb.append(seconds);
        sb.append(" s");

        return(sb.toString());
	}
	public Action getTableAction() {
		return new AbstractAction()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        ParkingSlot ps = model.getParkingSlot(modelRow);
		        Customer cc = ps.getCustomer();
		        if(cc != null) {
		        		if(cc.hasPaid() && (System.currentTimeMillis() - cc.getTimeSincePaid()) > Config.TIME_TO_LEAVE) {
		        			cc.setArrivalTime(cc.getTimeSincePaid());
		        			cc.setPaid(false);
		        			update();
		        		} else if(cc.hasPaid()) {   			
		        			ps.setCustomer(null);
		        			update();
		        		} else {
		        			String msg = textArea.getText();
		        			float price = cc.getVehicleType().getPrice();
		        			int ap = Config.ACCOUTING_PERIOD;
		        			long tt = System.currentTimeMillis() - cc.getArrivalTime();
		        			int ts = (int) ((tt / ap) + 1);
		        			
		        			int made1 = (int) (ts * price * 100);
		        			float made2 = made1 / 100;
		        			msg += "Ein " + cc.getVehicleType().getName() + " hat " + made2 + "€ bezahlt.\n";
		        			
		        			model.addTotalProfit(made2);
		        			textArea.setText(msg);
		        			
		        			cc.setPaid(true);
		        			cc.setTimeSincePaid(System.currentTimeMillis());
		        			update();
		        		}
		        }
		    }
		};
	}
}
