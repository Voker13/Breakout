 package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouselistener implements MouseListener{

	/**
	 * This object's controller
	 */
	private Controller controller;
	/**
	 * Initializes a new instance of this class with the given controller.
	 * @param controller
	 */
	public Mouselistener(Controller controller) {
		this.controller = controller;
	}	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// if the game is not running and if the game is not over
		// shoots the ball of the bar  
		if (!controller.isRunning() && !controller.isFinish()) {
			controller.getBall().setAngle(270);
			
			//TODO just for testting here <<--
//			controller.getBall().setAngle(225);
//			controller.getBall().setX(55);
//			controller.getBall().setY(65);
			
			controller.setRunning(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
