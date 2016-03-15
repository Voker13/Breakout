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
	 * 
	 */
	private static final long serialVersionUID = -5062635349747882628L;

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
		
		// creates a new font
		Font font = new Font("name", 0, 22);
		this.controller = controller;
		// sets bounds to the panel // backgroundcolor // layout
		this.setBounds(0, 0, controller.getFrameWidth(), controller.getOptionpanelHeight());
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		/*
		 * add a new label, to present the actual level.
		 * adds the bounds // - font // - color
		 */
		scoreLabel = new JLabel();
		scoreLabel.setBounds(230, -5, 150, 50);
		scoreLabel.setFont(font);
		//scoreLabel.setText("Score: "+controller.getScore());
		scoreLabel.setForeground(Color.white);
		add(scoreLabel);
		
		/*
		 * add a new label, to present the actual score.
		 * adds the bounds // - font // - color
		 */
		levelLabel = new JLabel();
		levelLabel.setBounds(130, -5, 100, 50);
		levelLabel.setFont(font);
		//levelLabel.setText("Score: "+controller.getLevel());
		levelLabel.setForeground(Color.white);
		add(levelLabel);
	}
	
	/**
	 * Zeichnet das Optionpanel mit den aktuellen Variablen.
	 * (hier nur die punkte die die leben symbolisieren)
	 */
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
