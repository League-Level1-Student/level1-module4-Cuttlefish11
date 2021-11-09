package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorClass implements ActionListener {	
	JButton add = new JButton ();
	JButton sub = new JButton ();
	JButton mul = new JButton ();
	JButton div = new JButton ();
	JLabel answer = new JLabel();
	int num1;
	int num2;
	JTextField numb1 = new JTextField(15);
	JTextField numb2 = new JTextField(15);
	
	CalculatorClass(){
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JPanel panel = new JPanel();
	panel.add(numb1);
	panel.add(numb2);
	panel.add(answer);
	panel.add(add);
	panel.add(sub);
	panel.add(mul);
	panel.add(div);
	frame.add(panel);
	frame.pack();

	add.setText("add");
	sub.setText("sub");
	mul.setText("mul");
	div.setText("div");
	add.addActionListener(this);
	sub.addActionListener(this);
	mul.addActionListener(this);
	div.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String numI = numb1.getText();
		String numII = numb2.getText();
		num1 = Integer.parseInt(numI);
		num2 = Integer.parseInt(numII);
		
		
	if (e.getSource() == add) {
		int function = num1+num2;
		answer.setText("" + function);
	}
	
	if (e.getSource() == sub) {
		int function = num1-num2;
		answer.setText("" + function);
	}
		
		if (e.getSource() == mul) {
			int function = num1*num2;
			answer.setText("" + function);
	}
		if (e.getSource() == div) {
			double function = (double)num1/num2;
			answer.setText("" + function);
		}
}
}