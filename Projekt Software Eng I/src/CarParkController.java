import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarParkController {

	private CarParkView view;
	private CarParkObject model;
	
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
		
		view.setFreieParkplaetze("" + model.getFreeParkingSlots());
		view.setParkplaetze("" + model.getTotalParkingSlots());
		view.setBelegteParkplaetze("" + model.getOccupiedParkingsSlots());
		
		addListener();
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
				
				view.setFreieParkplaetze("" + model.getFreeParkingSlots());
				view.setBelegteParkplaetze("" + model.getOccupiedParkingsSlots());
			}
			
		});
		
		this.view.setAusfahrtListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.setFreieParkplaetze("" + model.getFreeParkingSlots());
				view.setBelegteParkplaetze("" + model.getOccupiedParkingsSlots());
			}
			
		});
	}
	
	public CarPark getCarParkObject() {
		return this.model;
	}
	public CarParkView getCarParkView() {
		return this.view;
	}
}
