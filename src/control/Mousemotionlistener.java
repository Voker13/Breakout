package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mousemotionlistener implements MouseMotionListener{
	/**
	 * This object's controller
	 */
	private Controller controller;
	/**
	 * Initializes a new instance of this class with the given controller.
	 * @param controller
	 */
	public Mousemotionlistener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		controller.getBar().doLogic(e.getX());
	}
	
}
