package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Random;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JLabel dial1 = new JLabel();
	JLabel dial2 = new JLabel();
	JLabel dial3 = new JLabel();
	JButton reel = new JButton();
	Icon i1; 
	Icon i2;
	Icon i3;
	int score = 0;
	JLabel scoreDysplayer = new JLabel();
	
	SlotMachine() {
	i1 = createLabelImage("blue-dragon.png");
	i2 = createLabelImage("pngkit_dragon-png_3945852.png");
	i3 = createLabelImage("red-dragon.png");
    JPanel panel = new JPanel ();
	JFrame frame = new JFrame ();

	panel.add(scoreDysplayer);
	panel.add(reel);
	panel.add(dial1);
	panel.add(dial2);
	panel.add(dial3);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	
	reel.addActionListener(this);
	reel.setText("Reel");
	}
	
	private Icon createLabelImage(String fileName){
        java.net.URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return null;
	}
	Icon icon = new ImageIcon(imageURL);
	return icon;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource() == reel) {
		Random ran1 = new Random();
		int rando1 = ran1.nextInt(3);	
		if(rando1 == 0) {
		dial1.setIcon(i1);
		}
		else if(rando1 == 1) {
			dial1.setIcon(i2);
			}
		else if(rando1 == 2) {
			dial1.setIcon(i3);
			}
		
		Random ran2 = new Random();
		int rando2 = ran2.nextInt(3);	
		if(rando2 == 0) {
		dial2.setIcon(i1);
		}
		else if(rando2 == 1) {
			dial2.setIcon(i2);
			}
		else if(rando2 == 2) {
			dial2.setIcon(i3);
			}
		
		Random ran3 = new Random();
		int rando3 = ran3.nextInt(3);	
		if(rando3 == 0) {
		dial3.setIcon(i1);
		}
		else if(rando3 == 1) {
			dial3.setIcon(i2);
			}
		else if(rando3 == 2) {
			dial3.setIcon(i3);
			}
		if(rando1 == 0 && rando2 == 0 && rando3 == 0) {
			JOptionPane.showMessageDialog(null, "You win!");
			score++;
			}
			if(rando1 == 1 && rando2 == 1 && rando3 == 1) {
				JOptionPane.showMessageDialog(null, "You win!");	
				score++;
				}
			if(rando1 == 2 && rando2 == 2 && rando3 == 2) {
				JOptionPane.showMessageDialog(null, "YOU WIN!!!");	
				score+=2;
				}
			scoreDysplayer.setText("Your current score is " + score);
				}
	}
  
}

