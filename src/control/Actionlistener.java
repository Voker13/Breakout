package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actionlistener implements ActionListener {
    /**
     * This objects controller
     */
    private Controller controller;
	
   /**
    * Creates a new instance of this class with the given controller.
    * @param controller
    */
   public Actionlistener(Controller controller) {
	   this.controller = controller;
   }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getFrame().repaint();
		if (!controller.isRunning()) { 
			controller.getBall().setX(controller.getBar().getX() + controller.getBar().getWidth()/2 - controller.getBall().getSize()/2);
			controller.getBall().setY(controller.getBar().getY() - controller.getBall().getSize());
		}
		else {
			controller.doLogic();
			controller.getBall().move();
//			if (Optionpanel.roundLost == true) {
//				ball.setRunning(false);
//			}
		}
	};
}
