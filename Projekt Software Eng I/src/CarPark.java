import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public interface CarPark {
	/**
	 * 
	 * @return free ParkignSlot with smallest id
	 */
	public ParkingSlot getFreeParkingSlot();
	/**
	 * 
	 * @return
	 */
	public int getFreeParkingSlots();
	/**
	 * 
	 * @return
	 */
	public int getTotalParkingSlots();
	/**
	 * 
	 * @return
	 */
	public int getOccupiedParkingsSlots();
	/**
	 * 
	 * @return
	 */
	public ParkingSlot[] getParkingSlots();
	/**
	 * 
	 * @return success
	 */
	public ParkingSlot[] setParkingSlots(ParkingSlot[] ps1);
	/**
	 * 
	 * @return
	 */
	public String saveState();
	/**
	 * 
	 * @return
	 */
	public static CarPark loadState(String xml) {
		if(xml == null) return null;
		XStream xstream = new XStream();
		return (CarPark) xstream.fromXML(xml);
	}
	/**
	 * Speichert einen XML String in eine Datei, erstellt diese im XML-Format
	 * @param xml
	 * @param filename
	 */
	public static void saveToFile(String xml, String filename) {
		java.io.File file = new java.io.File(filename + ".xml");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		java.io.FileWriter fr = null;
		try {
			fr = new java.io.FileWriter(file);
			fr.write(xml);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
	            }
		}
	}
	public static String readFromFile(String filename) {
		java.io.File file = new java.io.File(filename + ".xml");
		
		if(!file.exists()) {
			System.err.println("Konnte nicht von Datei laden! Keine Datei gefunden.");
			return null;
		}
		
		java.io.FileReader fr = null;
		String s = "";
		try {
			fr = new java.io.FileReader(file);
			int i;
			while((i = fr.read()) != -1) s += (char) i;
			
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
            }
		}

		return (s.equals("")) ? null : s;
	}
}
