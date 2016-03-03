package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import control.Controller;

public class Optionpanel extends JPanel {
	/**
	 * This objects timer
	 */
	Timer t;
	/**
	 * This objects controller
	 */
	private Controller controller;
	//TODO What exactly does this actionListener?
	/**
	 * 
	 */
	ActionListener AL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();
		};
	};
	/**
	 * Creates a new instance of this class with the given controller and the standard properties.
	 * @param controller
	 */
	public Optionpanel(Controller controller) {
		this.controller = controller;
		this.setBounds(0, 0, controller.getFrameWidth(), controller.getFrameHeight());
		this.setBackground(Color.DARK_GRAY);
		
		t = new Timer(5,AL);
		t.start();
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
