package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Time;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Controller;
import control.GameThread;
import control.Main;
import control.Mouselistener;
import control.Mousemotionlistener;
import model.Ball;
import model.Bar;
import model.Grid;

public class Gamepanel extends JPanel {	
	/**
	 * This gamepanel's thread
	 */
	private GameThread thread;
	/**
	 * This gamepanel's controller
	 */
	private Controller controller;
	/**
	 * Creates a new instance of this class with the given controller and the standard properties.
	 * @param controller
	 */
	public Gamepanel(Controller controller) {
		this.setLayout(null);
		this.controller = controller;
		this.setBounds(0, controller.getOptionpanelHeight() , controller.getPanelWidth(), controller.getPanelHeight());
		this.setBackground(Color.BLACK);
		
		this.addMouseListener(new Mouselistener(controller));
		this.addMouseMotionListener(new Mousemotionlistener(controller));
	}
	
	public void doTransition() {
		
		java.net.URL imgurl = Main.class.getResource("/animation/newLevel.gif");
		Icon gif = new ImageIcon(imgurl);
		
		JLabel label = new JLabel(gif);
		label.setBounds(0, 0, controller.getPanelWidth(), controller.getPanelHeight());
		this.add(label);
		this.repaint();

		long t_1 = System.currentTimeMillis();
		long t_2 = System.currentTimeMillis();
		while (t_2-t_1 < 1600) {
			t_2 = System.currentTimeMillis();
//			System.out.println(t_2-t_1);
		}
		
		controller.getGrid().fill(controller.getLevel());
		this.repaint();
		
		t_1 = System.currentTimeMillis();
		t_2 = System.currentTimeMillis();
		while (t_2-t_1 < 1600) {
			t_2 = System.currentTimeMillis();
//			System.out.println(t_2-t_1);
		}
		label.setVisible(false);
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ball ball = controller.getBall();
        Bar bar = controller.getBar();
        Grid grid = controller.getGrid();
        g2.setColor(Color.lightGray);
        g2.drawOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        g2.fillOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        g2.drawRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        g2.fillRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        for (int i=0; i<controller.getGrid().getArrayLenghtD1(); i++) {
			for (int j=0; j<controller.getGrid().getArrayLenghtD2(); j++) {
				if (grid.getBrick(i, j).isVisible()) {
					g2.setColor(grid.getBrick(i, j).getColor());
					g2.drawRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
					g2.fillRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
				}
			}
		}
    }
	
}
