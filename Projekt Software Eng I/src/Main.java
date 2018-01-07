
public class Main {

	
		  static CarParkController controller;

		    /**
		     * Diese Klasse wird nur dazu benutzt alle nötigen
		     * Komponenten zu Initialisieren und die erste
		     * View anzuzeigen
		     */
		    public static void main(String [] args){
		        controller = new CarParkController();

		        controller.showView();
		    }
	

}
