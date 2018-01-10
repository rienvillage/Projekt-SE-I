import java.util.Map;
import java.util.HashMap;

// Singleton Instanzen in unserem Parkhaus - ggf. noch zu implementieren:
// CarPark, Array mit Parking Slots, CarParkController, CarParkView

public class VehicleType {

	private static final class Internal {
		public static final VehicleType instance = new VehicleType();
	}

	private final Map<String, VehicleType> map = new HashMap<String, VehicleType>();
	private static String[] allowedVehicles = { "PKW", "Pickup", "SUV", "Zweirad", "Trike", "Quad" };
	private static float[][] vehicleSizeAndPrice = { { 5.0f, 2.3f, 2.4f }, { 6.0f, 2.5f, 3.2f }, { 5.0f, 2.5f, 2.8f },
			{ 3.0f, 1.8f, 1.2f }, { 3.0f, 2.0f, 1.60f }, { 3.0f, 2.2f, 2.0f } };
	
	private float breite;
	private float laenge;
	private float price;
	private String name;
	
	private VehicleType() {
		
	}

	private VehicleType(float breite, float laenge, float price, String name) {
		this.breite = breite;
		this.laenge = laenge;
		this.price = price;
		this.name = name;
	}

	private int contains(String input) {
		int i = 0;
		for (String vehicle : allowedVehicles) {
			if (vehicle.equals(input)) {
				return i++;
			}
			++i;
		}
		return -1;
	}

	public static final VehicleType getInstance(String name) throws NullPointerException {
		VehicleType tmp = null;
		int pos = Internal.instance.contains(name);
		if (pos > -1) {
			tmp = Internal.instance.map.get(name);
			if (tmp == null) {
				tmp = new VehicleType(vehicleSizeAndPrice[pos][0], vehicleSizeAndPrice[pos][1],
						vehicleSizeAndPrice[pos][2], name);
				Internal.instance.map.put(name, tmp);
			}
		}
		return tmp;
	}

	public final String getName() {
		return name;
	}
	public final float getSize() {
		return breite * laenge;
	}

	public final float getPrice() {
		return price;
	}
}
