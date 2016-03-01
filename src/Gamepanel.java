import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gamepanel extends JPanel {	
	
	public Ball ball;
	public Bar bar;
	public Grid grid;
	Timer t;
	public static final int PANELWIDTH = Main.f_width-6;
	public static final int PANELHEIGHT = Main.f_height-40;
	
	Gamepanel() {
		this.setBounds(0, Main.OptionBarHeight, PANELWIDTH, PANELHEIGHT);
		this.setBackground(Color.white);
		bar = new Bar();
		ball = new Ball(bar.getX()+bar.getWidth()/2,bar.getY());
		grid = new Grid();
		grid.fill();
		t = new Timer(5,AL);
		this.addMouseListener(ML);
		this.addMouseMotionListener(MML);
		t.start();
	}
	
	MouseMotionListener MML = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			bar.doLogic(e.getX());
		}
		
	};
	
	MouseListener ML = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (!ball.isRunning()) {
				ball.setAngle(270);
				ball.setRunning(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	ActionListener AL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();
			if (!ball.isRunning()){ 
				ball.setX(bar.getX() + bar.getWidth()/2 - ball.getSize()/2);
				ball.setY(bar.getY() - ball.getSize());
			}
			else {
				ball.doLogic(bar, grid);
				ball.move();
				if (Optionpanel.roundLost == true) {
					Optionpanel.roundLostLogic();
					ball.setRunning(false);
				}
			}
		};
	};
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        g2.fillOval((int)ball.getX(), (int)ball.getY(), ball.getSize(), ball.getSize());
        g2.drawRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        g2.fillRect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (grid.getBrick(i, j).isVisible()) {
					g2.setColor(grid.getBrick(i, j).getColor());
					g2.drawRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
					g2.fillRect(grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight());
				}
			}
		}
    }
	
}
