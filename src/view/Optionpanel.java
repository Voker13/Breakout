package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controller;

public class Optionpanel extends JPanel {

	/**
	 * This objects controller
	 */
	private Controller controller;

	private JLabel scoreLabel;
	private JLabel levelLabel;
	
	/**
	 * Creates a new instance of this class with the given controller and the standard properties.
	 * @param controller
	 */
	public Optionpanel(Controller controller) {
		
		Font font = new Font("name", 0, 22);
		this.controller = controller;
		this.setBounds(0, 0, controller.getFrameWidth(), controller.getOptionpanelHeight());
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		scoreLabel = new JLabel();
		scoreLabel.setBounds(230, -5, 100, 50);
		scoreLabel.setFont(font);
		scoreLabel.setText("Score: "+controller.getScore());
		scoreLabel.setForeground(Color.white);
		add(scoreLabel);
		
		levelLabel = new JLabel();
		levelLabel.setBounds(130, -5, 100, 50);
		levelLabel.setFont(font);
		levelLabel.setText("Score: "+controller.getLevel());
		levelLabel.setForeground(Color.white);
		add(levelLabel);
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        for (int i=0; i<controller.getLifes(); i++) {
        	g2.drawOval(20+i*20, 15, 10, 10);
            g2.fillOval(20+i*20, 15, 10, 10);
        }
    }

	/**
	 * @return the scoreLabel
	 */
	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	/**
	 * @param scoreLabel the scoreLabel to set
	 */
	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	/**
	 * @return the levelLabel
	 */
	public JLabel getLevelLabel() {
		return levelLabel;
	}

	/**
	 * @param levelLabel the levelLabel to set
	 */
	public void setLevelLabel(JLabel levelLabel) {
		this.levelLabel = levelLabel;
	}

	
}
