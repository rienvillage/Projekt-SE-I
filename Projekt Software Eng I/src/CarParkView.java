import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CarParkView extends JFrame {
	
	 	private JLabel lbl1 = new JLabel("Eingabe: ");
	    
	    private JButton parkplatzErstellen = new JButton("Parkhaus erstellen");
	    private JButton einfahrt = new JButton("Einfahrt");
	    private JButton ausfahrt = new JButton("Ausfahrt");
	    private JTextArea txtErg = new JTextArea();
	    
	    public CarParkView() {
	    	super("Parkhaus");
	    	initForm();
	    }

		private void initForm() {
			 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setLayout(new FlowLayout());
		        this.setBounds(200, 200, 500, 100);

		        this.add(lbl1);
		        
		        this.add(einfahrt);
		        this.add(ausfahrt);
		        this.add(txtErg);
			
		}
		
		 public void resetView(){
		      
		        this.txtErg.setText("");
		    }

		    
		    
		    public void setTextField(String erg) {
		    	this.txtErg.setText(erg);
		    }

		    public void setParkplatzSize(String erg){
		        this.txtErg.setText(erg);
		    }
		    
		    public void setParkplatzErstellen(ActionListener l) {
		    	this.parkplatzErstellen.addActionListener(l);
		    }

		    /**
		     * Funktionen bereitstellen, mit denen man später aus
		     * dem Controller die nötigen Listener hinzufügen kann
		     */
		    public void setEinfahrtListener(ActionListener l){
		        this.einfahrt.addActionListener(l);
		    }

		    public void setAusfahrtListener(ActionListener l){
		        this.ausfahrt.addActionListener(l);
		    }

}
