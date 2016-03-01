package control;

import javax.swing.Timer;

import model.*;
import view.Frame;

public class Controller {

	private int optionpanelHeight = 40;
	private int frameHeight = 600 + optionpanelHeight;
	private int frameWidth = 400;
	private Ball ball;
	private Bar bar;
	private Grid grid;
	private int panelWidth = frameWidth-6;
	private int panelHeight = frameHeight-40;
	private int lifes = 3;
	private boolean running = false;
	private Frame frame;
	
	//TODO Empty constructor? maybe make it private
	public Controller() {}
	/**
	 * Initialises the game, adding a bar, a ball and the bricks to the field.
	 */
	public void initialize() {
		bar = new Bar(panelWidth, panelHeight);
		ball = new Ball(bar.getX()+bar.getWidth()/2, bar.getY(), panelWidth, panelHeight);
		grid = new Grid();
		grid.fill();
		frame = new Frame(this);
	}
	/**
	 * Stops the ball and resets the lives to 3.
	 */
	public void reset() {
		lifes = 3; 
		running = false;
	}
	/**
	 * This method is called each tick to move the ball and check for any collisions.
	 */
	public void doLogic() {
		
		//Bounce on the left border?
		if (ball.getX() <= 0) {
			ball.setX(ball.getX() + ball.getSPEED());
			ball.doRightLeftBounceLogic();
		}
		//Bounce on the right border?
		else if (ball.getX() +ball.getSize() >= panelWidth) {
			ball.setX(ball.getX() - ball.getSPEED());
			ball.doRightLeftBounceLogic();
		}
		//Bounce on the top border?
		else if (ball.getY() <= 0) {
			ball.setY(ball.getY() + ball.getSPEED());
			ball.doTopBottomBounceLogic();
		}
		//Bounce on the bar?
		else if (ball.intersects(bar)) {
			ball.setY(ball.getY() - ball.getSPEED());
			ball.doBarBounceLogic(bar);
		}
		//Bounce on the bottom border?
		else if (ball.getY()+ball.getSize() >= panelHeight) {
			lifes --;
			running = false;
		}
		//Collides with an brick?
		else {
			Brick brick = ball.intersects(grid); 
			if (brick != null) {
				 //Brick and Ball intersecting at an edge
				if (ball.getMiddleX() > brick.getX() && ball.getMiddleX() < brick.getX()+brick.getWidth()) {
					ball.doTopBottomBounceLogic();
				}
				else if (ball.getMiddleY() > brick.getY() && ball.getMiddleY() < brick.getY()+brick.getHeight()) {
					ball.doRightLeftBounceLogic();
				}
				 //Brick and Ball intersecting at a corner
				else {
					 //LinksOben
					if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() < brick.getY()) {
						ball.doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY());
						// TODO just placeholder
					}
					 //LinksUnten
					else if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						ball.doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY()+brick.getHeight());
					}
					 //RechtsOben
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() < brick.getY()) {
						ball.doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY());
						// TODO just placeholder
					}
					 //RechtsUnten
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						ball.doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY()+brick.getHeight());
					}
				}
				brick.setVisible(false);
			}
		}
		
		ball.setAngle(ball.getAngle() % 360);
	}
	
	/**
	 * Returns the optionpanel's height.
	 * @return
	 */
	public int getOptionpanelHeight() {
		return optionpanelHeight;
	}
	/**
	 * Sets the optionpanel's height to the given value.
	 * @param optionpanelHeight
	 */
	public void setOptionpanelHeight(int optionpanelHeight) {
		this.optionpanelHeight = optionpanelHeight;
	}
	/**
	 * Returns the actual height of the frame.
	 * @return
	 */
	public int getFrameHeight() {
		return frameHeight;
	}
	/**
	 * Sets the height of the frame to the given value.
	 * @param frameHeight
	 */
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}
	/**
	 * Returns the frame's actual width.
	 * @return 
	 */
	public int getFrameWidth() {
		return frameWidth;
	}
	/**
	 * Sets the frames width to the given value.
	 * @param frameWidth
	 */
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
	/**
	 * Returns the actually used ball.
	 * @return
	 */
	public Ball getBall() {
		return ball;
	}
	/**
	 * Sets the given ball-object to be used.
	 * @param ball
	 */
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	/**
	 * Returns the actually used bar.
	 * @return
	 */
	public Bar getBar() {
		return bar;
	}
	/**
	 * Sets the given bar-object to be used.
	 * @param bar
	 */
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	/**
	 * Returns the actually used Grid.
	 * @return
	 */
	public Grid getGrid() {
		return grid;
	}
	/**
	 * Sets the given grid-object to be used.
	 * @param grid
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	/**
	 * Returns the panel's actual width.
	 * @return
	 */
	public int getPanelWidth() {
		return panelWidth;
	}
	/**
	 * Sets the panel's width to the given value.
	 * @param panelWidth
	 */
	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}
	/**
	 * Returns the panel's actual height.
	 * @return
	 */
	public int getPanelHeight() {
		return panelHeight;
	}
	/**
	 * sets the panel's height to the given value.
	 * @param panelHeight
	 */
	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}
	/**
	 * Returns the actual number of lives left.
	 * @return
	 */
	public int getLifes() {
		return lifes;
	}
	/**
	 * Sets the amount of lives to the given value.
	 * @param lifes
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	/**
	 * Returns true, if the game is actually running and false otherwise.
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * Should be set to true as the game starts running(the ball starts moving), and false in case of the opposite event.
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * Returns the actually used frame.
	 * @return
	 */
	public Frame getFrame() {
		return frame;
	}
	/**
	 * Sets the given frame to be used.
	 * @param frame
	 */
	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	
}
