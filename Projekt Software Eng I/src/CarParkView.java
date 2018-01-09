import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CarParkView extends JFrame {

	private static int cid = 0;

	private JLabel lbl1 = new JLabel("Eingabe: ");

	private JButton parkplatzErstellen = new JButton("Parkhaus erstellen");
	private JButton einfahrt = new JButton("Einfahrt");
	private JButton ausfahrt = new JButton("Ausfahrt");
	private JTextArea txtErg = new JTextArea();

	private JLabel lbl2 = new JLabel("Freie Parkplaetze: -1");
	private JLabel lbl3 = new JLabel("Parkplaetze: -1");
	private JLabel lbl4 = new JLabel("Belegte Parkplaetze: -1");

	private Object[] Kunden = new ButtonItem[Config.PH_SIZE];
	private JList jlist1;

	public CarParkView() {
		super("Parkhaus");
		initForm();
	}

	private void initForm() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setBounds(200, 100, 500, 600);

		this.add(lbl3);
		this.add(lbl2);
		this.add(lbl4);

		this.add(lbl1);
		this.add(einfahrt);
		this.add(ausfahrt);
		this.add(txtErg);

		for (int i = 0; i < Kunden.length; i++) {
			ButtonItem jbt = new ButtonItem("Kunde " + (i + 1));
			Kunden[i] = jbt;
		}

		jlist1 = new JList(Kunden);
		jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist1.setVisibleRowCount(5);

		this.add(jlist1);

	}

	public void resetView() {
		this.txtErg.setText("");
	}

	public void addToJList(int id) {
		// this.jlist1.add(comp);
		this.jlist1.add(new JButton("Kunde " + cid++ + ": "));
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

	public void setEinfahrtListener(ActionListener l) {
		this.einfahrt.addActionListener(l);
	}

	public void setAusfahrtListener(ActionListener l) {
		this.ausfahrt.addActionListener(l);
	}

	class ButtonListRenderer extends JButton implements ListCellRenderer {
		public Component getListCellRendererComponent(JList comp, Object value, int index, boolean isSelected,
				boolean hasFocus) {
			setEnabled(comp.isEnabled());
			setFont(comp.getFont());
			setText(value.toString());

			if (isSelected) {
				setBackground(comp.getSelectionBackground());
				setForeground(comp.getSelectionForeground());
			} else {
				setBackground(comp.getBackground());
				setForeground(comp.getForeground());
			}

			return this;
		}
	}

	public class ButtonItem {
		private JButton button;

		public ButtonItem(String name) {
			this.button = new JButton(name);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(button.getText() + " was clicked.");
				}
			});
		}

		public JButton getButton() {
			return button;
		}

		@Override
		public String toString() {
			return button.getText();
		}
	}
}
