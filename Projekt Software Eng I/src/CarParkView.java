import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarParkView extends JFrame {

	private static int cid = 0;

	private JButton parkplatzErstellen = new JButton("Parkhaus erstellen");
	private JButton einfahrt = new JButton("Einfahrt");
	private JTextArea txtErg = new JTextArea();

	private JLabel lbl2 = new JLabel("Freie Parkplaetze: -1");
	private JLabel lbl3 = new JLabel("Parkplaetze: -1");
	private JLabel lbl4 = new JLabel("Belegte Parkplaetze: -1");

	//private Object[] Kunden = new ButtonItem[Config.PH_SIZE];
	private JList jlist1 = null;
	private JScrollPane jsp = new JScrollPane();

	public CarParkView() {
		super("Parkhaus");
		initForm();
	}

	@SuppressWarnings("unchecked")
	private void initForm() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setBounds(200, 100, 500, 600);

		this.add(lbl3);
		this.add(lbl2);
		this.add(lbl4);

		this.add(einfahrt);
		this.add(txtErg);

		
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
		String[] columnNames = {"Kunde auf Parkplatz", "Einfahrzeit", "Bezahlt", "Ausfahren / Bezahlen"};
		
		String[][] Kunden = new String[Config.PH_SIZE][4];
	
		for(int i = 0; i < Kunden.length; i++) {
			Kunden[i][0] = "frei";
			Kunden[i][1] = "-";
			Kunden[i][2] = "false";
			Kunden[i][3] = "Ausfahrt";
		}
		
		DefaultTableModel model = new DefaultTableModel(Kunden, columnNames);
		JTable table = new JTable( model );
		
		jsp.setViewportView(table);
		
		this.add(jsp);
		
		return table;
	}
	public void setEinfahrtListener(ActionListener l) {
		this.einfahrt.addActionListener(l);
	}
	public void setAusfahrtListener(ActionListener l) {
		
	}

}
