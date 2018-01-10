import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarParkView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton parkplatzErstellen = new JButton("Parkhaus erstellen");
	private JButton einfahrt = new JButton("Einfahrt");
	private JTextArea txtErg = new JTextArea();

	private JLabel lbl2 = new JLabel("Freie Parkplaetze: -1");
	private JLabel lbl3 = new JLabel("Parkplaetze: -1");
	private JLabel lbl4 = new JLabel("Belegte Parkplaetze: -1");
	
	private JButton reset = new JButton("Reset");
	private JComboBox<String> box = null;

	//private Object[] Kunden = new ButtonItem[Config.PH_SIZE];

	private JScrollPane jsp;
	private JScrollPane jsp2;
	
	private JTextArea jta = null;

	public CarParkView() {
		super("Parkhaus");
		initForm();
	}

	private void initForm() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setBounds(200, 100, 550, 600);		
	}
	
	public void addParkLabels() {
		this.add(lbl3);
		this.add(lbl2);
		this.add(lbl4);
	}
	
	public void addEinfahrtButton() {
		this.add(einfahrt);
	}
	
	public void addConsoleText() {
		this.add(txtErg);
	}
	
	public void addResetButton() {
		this.add(reset);
	}
	
	public void resetView() {
		this.txtErg.setText("");
	}

	public void setTextField(String erg) {
		this.txtErg.setText(erg);
	}

	public void setParkplatzSize(String erg) {
		this.txtErg.setText(erg);
	}

	public void setParkplatzErstellen(ActionListener l) {
		this.parkplatzErstellen.addActionListener(l);
	}
	
	public void setReset(ActionListener l) {
		this.reset.addActionListener(l);
	}
	
	public void setFreieParkplaetze(String str) {
		this.lbl2.setText("Freie Parkplaetze: " + str);
	}

	public void setParkplaetze(String str) {
		this.lbl3.setText("Parkplaetze: " + str);
	}

	public void setBelegteParkplaetze(String str) {
		this.lbl4.setText("Belegte Parkplaetze: " + str);
	}

	public JTable addTable() {
		String[] columnNames = {"Parkplatz", "Fahrzeugtyp", "Einfahrzeit", "Bezahlt", "Ausfahren / Bezahlen"};
		
		String[][] Kunden = new String[Config.PH_SIZE][5];
	
		for(int i = 0; i < Config.PH_SIZE; i++) {
			Kunden[i][0] = "frei";
			Kunden[i][1] = "-";
			Kunden[i][2] = "-";
			Kunden[i][3] = "false";
			Kunden[i][4] = "Ausfahrt";
		}
		
		DefaultTableModel model = new DefaultTableModel(Kunden, columnNames);
		JTable table = new JTable( model );
		
		jsp = new JScrollPane(table);
		
		this.add(jsp);
		
		return table;
	}
	
	public JTextArea addTextArea() {
		this.jta = new JTextArea(5, 15);
		
		jta.setEditable(false);
		
		jsp2 = new JScrollPane(jta);
		this.add(jsp2);
		
		return jta;
	}
	
	public JComboBox<String> addComboBox() {
		String[] vtype = {"PKW", "Pickup", "SUV", "Zweirad", "Trike", "Quad"};
		
		this.box = new JComboBox<String>(vtype);
		this.add(box);
		
		return this.box;
	}
	
	public void setEinfahrtListener(ActionListener l) {
		this.einfahrt.addActionListener(l);
	}
	
	public void setAusfahrtListener(ActionListener l) {
		
	}
}
