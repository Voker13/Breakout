package view;
import java.awt.Color;
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

	/**
	 * Creates a new instance of this class with the given controller and the standard properties.
	 * @param controller
	 */
	public Optionpanel(Controller controller) {
		this.controller = controller;
		this.setBounds(0, 0, controller.getFrameWidth(), controller.getOptionpanelHeight());
		this.setBackground(Color.DARK_GRAY);
		JLabel label = new JLabel();
//		label.setBounds(300, 20, 200, 50); //TODO
		label.setText("Score: "+controller.getScore());
		label.setForeground(Color.white);
		add(label);
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
}
