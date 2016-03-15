package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Controller;
import model.HighscoreEntry;

public class FinalFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8504661962480472563L;
	private int finalFrameWidth = 300;
	private int finalFrameHeight = 195;
	private int finalFrameX;
	private int finalFrameY;
	JLabel finalScore;
	JPanel finalPanel;
	
	
	public FinalFrame(Controller controller) {
		
		Font font = new Font("name", 0, 22);
		finalFrameX = controller.getFrameX()+(controller.getFrameWidth()/2)-(finalFrameWidth/2);
		finalFrameY = controller.getFrameY()+(controller.getFrameHeight()/3)-(finalFrameHeight/2);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(finalFrameX, finalFrameY, finalFrameWidth, finalFrameHeight);
		
		finalPanel = new JPanel();
		finalPanel.setBounds(0, 0, finalFrameWidth, finalFrameHeight);
		finalPanel.setBackground(Color.white);
		finalPanel.setLayout(null);
		this.add(finalPanel);
		
		finalScore = new JLabel("HelloWorld");
		finalScore.setBounds(50, 0, finalFrameWidth, 50);
		finalScore.setFont(font);
		finalScore.setText("Your final score: "+controller.getScore());
		finalScore.setForeground(Color.black);
		finalPanel.add(finalScore);
		
		JLabel finalEnterLabel = new JLabel("HelloWorld");
		finalEnterLabel.setBounds(30, 30, finalFrameWidth, 50);
		finalEnterLabel.setFont(font);
		finalEnterLabel.setText("Please enter your name!");
		finalEnterLabel.setForeground(Color.black);
		finalPanel.add(finalEnterLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(20, 80, finalFrameWidth-40, 30);
		textField.setHorizontalAlignment(JTextField.CENTER);
		finalPanel.add(textField);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				controller.getHighscoreList().addEntry(new HighscoreEntry(textField.getText(), controller.getScore()));
				controller.getScoreFrame().setText();
				controller.save();
				controller.getScoreFrame().setText();
				controller.getFinalFrame().dispose();
				controller.reset();
				
			}
        });
		saveButton.setBounds(100, 120, 100, 30);
		finalPanel.add(saveButton);
		
	}


	/**
	 * @return the finalScore
	 */
	public JLabel getFinalScore() {
		return finalScore;
	}


	/**
	 * @param finalScore the finalScore to set
	 */
	public void setFinalScore(JLabel finalScore) {
		this.finalScore = finalScore;
	}


	/**
	 * @return the finalPanel
	 */
	public JPanel getFinalPanel() {
		return finalPanel;
	}


	/**
	 * @param finalPanel the finalPanel to set
	 */
	public void setFinalPanel(JPanel finalPanel) {
		this.finalPanel = finalPanel;
	}
	
}
