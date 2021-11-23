package _12_slot_machine;

import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine {

	SlotMachine(){
	JFrame frame = new JFrame ();
	JPanel panel = new JPanel ();
	JLabel dial1 = new JLabel();
	JLabel dial2 = new JLabel();
	JLabel dial3 = new JLabel();
	
	panel.add(dial1);
	panel.add(dial2);
	panel.add(dial3);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	
	
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
  
}
