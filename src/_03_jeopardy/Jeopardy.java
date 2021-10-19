package _03_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton, fifthButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private Clip jeopardyThemeClip;



	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
frame.setVisible(true);
		// 2. Give your frame a title
frame.setTitle("Za Jeopardy Frame");
		// 3. Create a JPanel variable to hold the header using the createHeader method
JPanel p = new JPanel();
frame.add(p);
frame.add(quizPanel);
frame.pack();
// 4. Add the header component to the quizPanel
quizPanel.add(createHeader("Jeopardy"));
		// 5. Add the quizPanel to the frame

		// 6. Use the createButton method to set the value of firstButton
firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.

		// 9. Use the secondButton variable to hold a button using the createButton
		// method
secondButton = createButton ("$400");
quizPanel.add(secondButton);

thirdButton = createButton ("$600");
quizPanel.add(thirdButton);

fourthButton = createButton ("$800");
quizPanel.add(fourthButton);

fifthButton = createButton ("$1000");
quizPanel.add(fifthButton);

		// 10. Add the secondButton to the quizPanel
firstButton.addActionListener(this);
secondButton.addActionListener(this);
thirdButton.addActionListener(this);
fourthButton.addActionListener(this);
fifthButton.addActionListener(this);
frame.pack();
// 11. Add action listeners to the buttons (2 lines of code)

		// 12. Write the code to complete the actionPerformed() method below

		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
		
		 /*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */		
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(String dollarAmount) {
		
		// Create a new JButton
JButton jb = new JButton();
		// Set the text of the button to the dollarAmount
jb.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
buttonCount +=1;
		// Return your new button instead of the temporary button

		return jb;

	}


	public void actionPerformed(ActionEvent e) {
		
		// Remove this temporary message after testing:


		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
if (buttonPressed == firstButton) {
askQuestion ("What came first? The Cretatious, Triassic, or Jurassic period?", "Triassic", 200);	
}
if (buttonPressed == secondButton) {
askQuestion ("9x + √16 + (9•5) = 319. Solve for x.", "30", 400);	
}
if (buttonPressed == thirdButton) {
askQuestion ("Which of the following is an insect: Scorpion, Butterfly, Spider, Crab, or Centipede?", "Butterfly", 600);
}
if (buttonPressed == fourthButton) {
askQuestion ("What is the answer to life, the universe, and everything?", "42", 800);	
}
if (buttonPressed == fifthButton) {
askQuestion ("Muahahahaha, only I know the answer!", "...you'll never know!", 1000);	
}
			// Call the askQuestion() method
 
		// Complete the code in the askQuestion() method. When you play the game, the score should change.

		// If the buttonPressed was the secondButton

			// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		
		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
		playJeopardyTheme();
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String answer1 = JOptionPane.showInputDialog(question);
		
		// Stop the theme music when they have entered their response. 
		
		// If the answer is correct
if (answer1.equals(correctAnswer)) {
	stopJeopardyTheme();
	score += prizeMoney;
	JOptionPane.showMessageDialog(null, "correct");
}
else {
	stopJeopardyTheme();
	score -= prizeMoney;
	JOptionPane.showMessageDialog(null, "Incorrect, the correct answer is " + correctAnswer);
}
		
// Increase the score by the prizeMoney

			// Pop up a message to tell the user they were correct

		// Otherwise

			// Decrement the score by the prizeMoney

			// Pop up a message to tell the user they were wrong and give them the correct answer

		// Call the updateScore() method
updateScore();
	}

	public void playJeopardyTheme() {
		String fileName = "src/_03_jeopardy/jeopardy.wav";
		// Note: use .wav files
		try {
			jeopardyThemeClip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
			jeopardyThemeClip.open(inputStream);
			jeopardyThemeClip.start();
		} catch (Exception e) {
			System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
		}
	}

	public void stopJeopardyTheme() {
		jeopardyThemeClip.stop();

	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
