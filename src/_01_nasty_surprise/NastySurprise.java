package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener{
JFrame f = new JFrame();
JPanel p = new JPanel ();
JButton b = new JButton();
JButton b2 = new JButton();

public NastySurprise() {
p.add(b);
p.add(b2);
f.add(p);
f.pack();
f.setVisible(true);
b.setText("Trick");
b2.setText("Treat");
b.addActionListener(this);
b2.addActionListener(this);
}


private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}



@Override
public void actionPerformed(ActionEvent e) {
	JButton buttonPressed = (JButton) e.getSource();
	System.out.println();
		if (buttonPressed.equals(b)) {
	showPictureFromTheInternet("https://www.istockphoto.com/photo/pumpkin-gm491684958-75750243");
	System.out.println("Trick Works");
	}
	if (buttonPressed.equals(b2)) {
	showPictureFromTheInternet("https://www.istockphoto.com/vector/reaper-gm156518976-11248110");	
	System.out.println("Treat Works");
	}
}




}

