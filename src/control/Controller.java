package control;

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
	private GameThread thread;
	private int score = 0;
	
	public Controller() {
		
	}
	/**
	 * Initializes the game, adding a bar, a ball and the bricks to the field.
	 */
	public void initialize() {
		bar = new Bar(panelWidth, panelHeight);
		ball = new Ball(bar.getX()+bar.getWidth()/2, bar.getY(), panelWidth, panelHeight);
		grid = new Grid();
		grid.fill(0);
		frame = new Frame(this);
		thread = new GameThread(this);
		thread.start();
	}
	/**
	 * Stops the ball and resets the lives to 3.
	 */
	public void reset() {
		score = 0;
		lifes = 3; 
		running = false;
	}
	/**
	 * This method is called each tick to move the ball and check for any collisions.
	 */
	public void doLogicBall() {
		
		//Bounce on the left border?
		if (ball.getX() <= 0) {
			ball.setX(ball.getX() + ball.getSpeed());
			doRightLeftBounceLogic();
		}
		//Bounce on the right border?
		else if (ball.getX() +ball.getSize() >= panelWidth) {
			ball.setX(ball.getX() - ball.getSpeed());
			doRightLeftBounceLogic();
		}
		//Bounce on the top border?
		else if (ball.getY() <= 0) {
			ball.setY(ball.getY() + ball.getSpeed());
			doTopBottomBounceLogic();
		}
		//Bounce on the bar?
		else if (ball.intersects(bar)) {
			ball.setY(ball.getY() - ball.getSpeed());
			doBarBounceLogic(bar);
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
					doTopBottomBounceLogic();
				}
				else if (ball.getMiddleY() > brick.getY() && ball.getMiddleY() < brick.getY()+brick.getHeight()) {
					doRightLeftBounceLogic();
				}
				 //Brick and Ball intersecting at a corner
				else {
					 //LinksOben
					if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() < brick.getY()) {
						doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY());
						// TODO just placeholder
					}
					 //LinksUnten
					else if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY()+brick.getHeight());
					}
					 //RechtsOben
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() < brick.getY()) {
						doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY());
						// TODO just placeholder
					}
					 //RechtsUnten
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY()+brick.getHeight());
					}
				}
				brick.setAlpha(brick.getAlpha() / 2);
				brick.setHardiness(brick.getHardiness() - 1);
				if (brick.getHardiness() == 0) {
					brick.setVisible(false);
					score += brick.getScore();
				}
			}
		}
		
		ball.setAngle(ball.getAngle() % 360);
	}
	
	/**
	 * This method sets the angel, when the ball is intersecting the BottomLeftCorner of a Brick.
	 * 
	 * @param x of the corner
	 * @param y of the corners
	 */
	public void doBottomLeftCornerBouncingLogic(int x, int y) {
		double atan = Math.toDegrees(Math.atan(absValue(ball.getMiddleY() - y) / absValue(ball.getMiddleX() - x)));
		ball.setAngle(ball.getAngle() + 2 * absValue(360 - atan - ball.getAngle()) + 180);
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the sides.
	 */
	public void doRightLeftBounceLogic() {
		ball.setAngle(ball.getAngle() - (ball.getAngle()-270)*2);
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the top and bottom.
	 */
	public void doTopBottomBounceLogic() {
		ball.setAngle(ball.getAngle() - (ball.getAngle()-180)*2);
	}
	/**
	 * This Method calculates the angle with the ball bounces from the bar, depending on the point hit.
	 * @param bar - The Object of the bar used.
	 */
	public void doBarBounceLogic(Bar bar) {
		double DeltaZ = (ball.getMiddleX()) - (bar.getX());
		if (DeltaZ < 0) { DeltaZ = 0;}
		else if (DeltaZ > bar.getWidth()) { DeltaZ = bar.getWidth();}
		double OnePer = (((double)bar.getWidth())/100);
		double z = OnePer * DeltaZ /100;
		ball.setAngle(190+z*160.0);
	}
	/**
	 * This method sets the angel, when the ball is intersecting the BottomRightCorner of a Brick.
	 * 
	 * @param x of the corner
	 * @param y of the corners
	 */
	public void doBottomRightCornerBouncingLogic(int x, int y) {
		double atan = Math.toDegrees(Math.atan(absValue(ball.getMiddleY() - y) / absValue(ball.getMiddleX() - x)));
		ball.setAngle(ball.getAngle() - 2 * absValue(360 - atan - ball.getAngle()) + 180);
	}
	/**
	 * This method calculates and returns the absolute value of the given number.
	 * @param x
	 */
	private double absValue(double x) {
		if (x < 0) {return x*(-1);}
		return x;
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
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	
}
