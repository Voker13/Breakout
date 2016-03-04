package control;

public class GameThread extends Thread {

	private Controller controller;
	private int FPS = 60;
	private double msPerFrame = 1000 / FPS;
	
	public GameThread(Controller controller) {
		this.controller = controller;
	}
	
	public void run() {
		while (true) {
			long startTime = System.currentTimeMillis();
			
			controller.getFrame().repaint();
			
			//sets the current score to the jlabel
			controller.getFrame().getOptionpanel().getLabel().setText("Score: "+controller.getScore());
			
			// setting the right coordinate to the ball and moves it
			if (!controller.isRunning()) {
				controller.getBall().setX(controller.getBar().getX() + controller.getBar().getWidth() / 2 - controller.getBall().getSize() / 2);
				controller.getBall().setY(controller.getBar().getY() - controller.getBall().getSize());
			} else {
				// wenn man das level durchgespielt hat.... -->>>
				if (controller.getGrid().isEmpty()) {
					controller.setRunning(false);
					controller.setLevel(controller.getLevel()+1);
					if (controller.getLevel() >= controller.getMaxLevel()) {
						// gewonnen / alle level durchgespielt
						System.out.println("Victory");
					}
					else {
						controller.getGrid().fill(controller.getLevel());
					}
				}
				else {
					controller.doLogicBall();
					controller.getBall().move();
				}
			}

			try {
				long endTime = System.currentTimeMillis();
				long sleepTime = (long) msPerFrame - (endTime - startTime);
				
//				System.out.println("Thread going to sleep for:" +
//				sleepTime + "ms");
				if (sleepTime > 0) {
					Thread.sleep(sleepTime);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
