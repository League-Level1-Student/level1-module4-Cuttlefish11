package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.jdi.event.Event;

public class chuckleClicker implements ActionListener {
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	
	public static void main(String[] args) {
		chuckleClicker x = new chuckleClicker (); 
	x.makeButtons();
	}
	
	void makeButtons(){
	JFrame JIF = new JFrame();
	JIF.setVisible(true);
	JPanel JP = new JPanel();
	b1.setText("Joke");
	b2.setText("Punchline");
	JP.add(b1);
	JP.add(b2);
	JIF.add(JP);
	JIF.pack();
	b1.addActionListener(this);
	b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
		JOptionPane.showMessageDialog(null, " ... ");	
		}
	
if (e.getSource() ==b2) {
	JOptionPane.showMessageDialog(null, "Rectum nearly killed him!");				
}	
}

	}
	

