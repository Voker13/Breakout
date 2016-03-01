package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouselistener implements MouseListener{

	private Controller controller;
	
	public Mouselistener(Controller controller) {
		this.controller = controller;
	}	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (!controller.isRunning()) {
			controller.getBall().setAngle(270);
//			ball.setRunning(true);
			controller.setRunning(true);
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
	
}
