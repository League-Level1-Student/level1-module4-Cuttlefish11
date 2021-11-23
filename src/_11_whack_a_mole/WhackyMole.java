package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WhackyMole implements ActionListener {
	JFrame frame = new JFrame();
	int score2 = 0;

	
	WhackyMole (){
		JPanel panel = new JPanel();	
		JLabel title = new JLabel();
		panel.add(title);
		
		Random ran = new Random();
		int rando = ran.nextInt(16);	
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton();
			if (i == rando) {
		b.setText("mole");
	}
		panel.add(b);
		b.addActionListener(this);
		}
			
		frame.add(panel);
		frame.setSize(320, 320);
		frame.setVisible(true);
	title.setText("Whack-a-mole");
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(((JButton) e.getSource()).getText()=="Mole") {
		frame = new JFrame();	
		score2++;
		System.out.println(score2);
	}
	frame = new JFrame();	
	
	
	
	}
}
