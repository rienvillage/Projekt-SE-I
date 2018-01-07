import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarParkController {

	private CarParkView _view;
	private CarParkObject _model;
	
	public CarParkController() {
		this._view = new CarParkView();
		int parkhausSize = 100;
		
		ParkingSlot[] parkingslots = new ParkingSlot[parkhausSize];
		for(int i = 0; i < parkhausSize; i++) {
			ParkingSlot ps = new ParkingSlotObject(i, null);
			parkingslots[i] = ps;
		
		_model = new CarParkObject(parkingslots);
		_view.setParkplatzSize("Ein Parkplatz mit "+parkhausSize+" Plätzen wurde erstellt");
		
		
		}
		
 
		addListener();
	}
	
	public void showView() {
		this._view.setVisible(true);
	}
	
	

	private void addListener() {
		
				
		
		
		this._view.setEinfahrtListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CustomerObject c = new CustomerObject();
				int slotId =_model.getFreeParkingSlot().getId();
				_model.getParkingSlots()[slotId].setCostumer(c);
				_view.setTextField("Ein Neuer Kunde ist eingefahren und hat den Slot "+slotId+" belegt");
				
			}
			
		});
		
		this._view.setAusfahrtListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
	}
}
