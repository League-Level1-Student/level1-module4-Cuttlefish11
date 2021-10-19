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
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == b1) {
			
		}
	
if (buttonPressed == b2) {
			
}	
}

	}
	

