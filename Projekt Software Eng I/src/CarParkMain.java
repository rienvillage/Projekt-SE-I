
public class CarParkMain {
	
	public static CarParkController controller;

	public static void main(String[] args) {
        controller = new CarParkController();

        controller.showView();
 
        Runtime.getRuntime().addShutdownHook( new Thread() {
        	  @Override public void run() {
        		  CarPark.saveToFile(controller.getCarParkObject().saveState(), "data");
        	  } 	  
        	});
	}
}
