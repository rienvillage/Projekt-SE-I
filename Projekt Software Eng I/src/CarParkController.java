import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CarParkController {

	private CarParkView view;
	private CarParkObject model;
	private JTable table;
	public CarParkController() {
		this.view = new CarParkView();
		
		try {
			model = (CarParkObject) CarPark.loadState(CarPark.readFromFile("data"));
			view.setParkplatzSize("Ein Parkplatz mit " + model.getParkingSlots().length + " Plaetzen wurde geladen.");
		} catch(NullPointerException e) {
			ParkingSlot[] parkingslots = new ParkingSlot[Config.PH_SIZE];
			for(int i = 0; i < Config.PH_SIZE; i++) {
				ParkingSlot ps = new ParkingSlotObject(i, null);
				parkingslots[i] = ps;
			
				model = new CarParkObject(parkingslots);
				view.setParkplatzSize("Ein Parkplatz mit " + Config.PH_SIZE + " Plaetzen wurde erstellt.");
			}
		}
		
		table = view.addTable();
		
		ButtonColumn buttonColumn = new ButtonColumn(table, this.getTableAction(), 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		//this.initTable();
		
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
				
				CustomerObject c = new CustomerObject();
				int slotId = model.getFreeParkingSlot().getId();
				model.getParkingSlots()[slotId].setCostumer(c);
				
				view.setTextField("Ein Neuer Kunde ist eingefahren und hat den Slot "+ slotId +" belegt");
				
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
	private void update() {
		for(int i = 0; i < Config.PH_SIZE; i++) {
			ParkingSlot ps = model.getParkingSlots()[i];
			if(ps.getCostumer() == null) {
				table.setValueAt("frei", i, 0);
				table.setValueAt("-", i, 1);
				table.setValueAt("false", i, 2);
				continue;
			} else {
				table.setValueAt(i, i, 0);
				table.setValueAt(this.calcTimeString(System.currentTimeMillis() - ps.getCostumer().getArrivalTime()), i, 1);
				table.setValueAt(ps.getCostumer().hasPaid(), i, 2);
			}
		}
		
		view.setFreieParkplaetze("" + model.getFreeParkingSlots());
		view.setParkplaetze("" + model.getTotalParkingSlots());
		view.setBelegteParkplaetze("" + model.getOccupiedParkingsSlots());
		
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
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        
		        if(model.getParkingSlots()[modelRow].getCostumer() != null) {
		        		if(model.getParkingSlots()[modelRow].getCostumer().hasPaid()) {
		        			model.getParkingSlots()[modelRow].setCostumer(null);
		        			update();
		        		} else {
		        			model.getParkingSlots()[modelRow].getCostumer().setPaid(true);
		        			update();
		        		}
		        }
		    }
		};
	}
}
