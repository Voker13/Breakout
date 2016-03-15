package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Controller;
import control.Main;
import control.Mouselistener;
import control.Mousemotionlistener;
import model.Ball;
import model.Bar;
import model.Grid;

public class Gamepanel extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -100041808732161989L;
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
		this.setBounds(0, controller.getOptionpanelHeight() , controller.getPanelWidth(), controller.getPanelHeight()); // setzt die bounds
		this.setBackground(Color.BLACK); // setzt den hintergrund auf schwarz
		
		this.addMouseListener(new Mouselistener(controller)); // fügt eine instance vom MouseListener zum Gamepanel hinzu
		this.addMouseMotionListener(new Mousemotionlistener(controller)); // fügt eine instance vom MouseMotionListener zum Gamepanel hinzu
	}
	
	/**
	 * Makes the transition from one Level to the next Level.
	 * Creates a new JLabel with a gif that we created
	 * and changes the Level(Grid) in the middle of the time.
	 */
	public void doTransitionToNextLevel() {
		
		java.net.URL imgurl = Main.class.getResource("/animation/newLevel.gif"); // ht sich die URL vom gif
		Icon gif = new ImageIcon(imgurl); // instanciiert ein neues image mit dem gif
		
		JLabel label = new JLabel(gif);
		label.setBounds(0, 0, controller.getPanelWidth(), controller.getPanelHeight());
		this.add(label); //fügt das label hinzu
		this.repaint(); // repaintet das Gamepanel

		// wartet 1600 ms ab (die hälfte der länge des gif)
		long t_1 = System.currentTimeMillis();
		long t_2 = System.currentTimeMillis();
		while (t_2-t_1 < 1600) {
			t_2 = System.currentTimeMillis();
//			System.out.println(t_2-t_1);
		}
		
		// füllt das grid mit dem neuen level und repainted es
		controller.getGrid().fill(controller.getLevel());
		this.repaint();
		
		// wartet 1600 ms ab (die hälfte der länge des gif)
		t_1 = System.currentTimeMillis();
		t_2 = System.currentTimeMillis();
		while (t_2-t_1 < 1600) {
			t_2 = System.currentTimeMillis();
//			System.out.println(t_2-t_1);
		}
		//blendet das label wieder aus, wenn es durchgelaufen ist
		label.setVisible(false);
	}
	
	/**
	 * zeichnet das Gamepanel mit den aktuellen coordinaten der objekte
	 */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // zur übersicht halber: neue instancen
        Ball ball = controller.getBall();
        Bar bar = controller.getBar();
        Grid grid = controller.getGrid();
        g2.setColor(Color.lightGray);
        // zeichnet den ball
        g2.drawOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        // füllt den ball
        g2.fillOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        // zeichnet die bar
        g2.drawRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        // füllt die bar
        g2.fillRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        // zeichnet die bricks
        for (int i=0; i<controller.getGrid().getArrayLenghtD1(); i++) {
			for (int j=0; j<controller.getGrid().getArrayLenghtD2(); j++) {
				if (grid.getBrick(i, j).isVisible()) {
					// holt sich die individielle farbe der bricks // zeichnet diese // füllt sie
					g2.setColor(grid.getBrick(i, j).getColor());
					g2.drawRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
					g2.fillRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
				}
			}
		}
    }
	
}
