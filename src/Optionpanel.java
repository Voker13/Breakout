import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Optionpanel extends JPanel {

	public static boolean roundLost;
	public static boolean LostTotal;
	public static int lifes;
	Timer t;
	
	public Optionpanel() {
		this.setBounds(0, 0, Main.f_width, Main.OptionBarHeight);
		this.setBackground(Color.DARK_GRAY);
		roundLost = false;
		LostTotal = false;
		lifes = 3;
		t = new Timer(5,AL);
		t.start();
	}
	
	ActionListener AL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();
		};
	};
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        for (int i=0; i<lifes; i++) {
        	g2.drawOval(20+i*20, 15, 10, 10);
            g2.fillOval(20+i*20, 15, 10, 10);
        }
    }
	
	public static void roundLostLogic() {
		lifes--;
		roundLost = false;
		if (lifes == 0) {
			LostTotal = true;
		}
	}
	
}
