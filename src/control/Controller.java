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
	
	
	public Controller() {
		
	}
	
	public void initialize() {
		bar = new Bar(panelWidth, panelHeight);
		ball = new Ball(bar.getX()+bar.getWidth()/2, bar.getY(), panelWidth, panelHeight);
		grid = new Grid();
		grid.fill();
		frame = new Frame(this);
	}
	
	public void reset() {
		lifes = 3; 
		running = false;
	}
	
	public void doLogic() {
		
		if (ball.getX() <= 0) {
			ball.setX(ball.getX() + ball.getSPEED());
			ball.doRightLeftBounceLogic();
		}
		
		else if (ball.getX() +ball.getSize() >= panelWidth) {
			ball.setX(ball.getX() - ball.getSPEED());
			ball.doRightLeftBounceLogic();
		}
		
		else if (ball.getY() <= 0) {
			ball.setY(ball.getY() + ball.getSPEED());
			ball.doTopBottomBounceLogic();
		}
		
		else if (ball.intersects(bar)) {
			ball.setY(ball.getY() - ball.getSPEED());
			ball.doBarBounceLogic(bar);
		}
		
		else if (ball.getY()+ball.getSize() >= panelHeight) {
			lifes --;
			running = false;
		}
		
		else {
			Brick brick = ball.intersects(grid); 
			if (brick != null) {
				/**
				 * Brick and Ball intersecting at an edge
				 */
				if (ball.getMiddleX() > brick.getX() && ball.getMiddleX() < brick.getX()+brick.getWidth()) {
					ball.doTopBottomBounceLogic();
				}
				else if (ball.getMiddleY() > brick.getY() && ball.getMiddleY() < brick.getY()+brick.getHeight()) {
					ball.doRightLeftBounceLogic();
				}
				/**
				 * Brick and Ball intersecting at a corner
				 */
				else {
					/**
					 * LinksOben
					 */
					if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() < brick.getY()) {
						ball.doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY());
						// TODO just placeholder
					}
					/**
					 * LinksUnten
					 */
					else if (ball.getMiddleX() < brick.getX() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						ball.doBottomLeftCornerBouncingLogic(brick.getX(), brick.getY()+brick.getHeight());
					}
					/**
					 * RechtsOben
					 */
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() < brick.getY()) {
						ball.doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY());
						// TODO just placeholder
					}
					/**
					 * RechtsUnten
					 */
					else if (ball.getMiddleX() > brick.getX()+brick.getWidth() && ball.getMiddleY() > brick.getY()+brick.getHeight()) {
						ball.doBottomRightCornerBouncingLogic(brick.getX()+brick.getWidth(), brick.getY()+brick.getHeight());
					}
				}
				brick.setVisible(false);
			}
		}
		
		ball.setAngle(ball.getAngle() % 360);
	}
	

	public int getOptionpanelHeight() {
		return optionpanelHeight;
	}

	public void setOptionpanelHeight(int optionpanelHeight) {
		this.optionpanelHeight = optionpanelHeight;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}

	public int getPanelHeight() {
		return panelHeight;
	}

	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	
}
