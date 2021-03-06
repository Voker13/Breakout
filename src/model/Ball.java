package model;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

	private double x; // the x coordinate of the ball
	private double y; // the y coordinate of the ball
	private final int size = 15; // the size of the ball
	private double speed = 4; // the speed of the ball
	private double angle = 0; // the direction of the balls movement
	private int panelWidth; 
	private int panelHeight;
	private double acceleration = 1.01;
	
	
	/**
	 * This constructor is used to create the standard-ball-object.
	 * Its x and y coordinate will be set to the middle of the bar.
	 */
	public Ball(int panelWidth, int panelHeight) {
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
	}
	
	/**
	 * This method moves the ball with the actual speed along the calculated angle.
	 */
	public void move() {
		x += Math.cos(angle*Math.PI/180)*this.getSpeed();
		y += Math.sin(angle*Math.PI/180)*this.getSpeed();
	}
	
	/**
	 * This method checks whether the ball collides with the bar and if so returns true.
	 * @param bar
	 * @return
	 */
	public boolean intersects(Bar bar) {
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.size, (float)this.size);
		Rectangle2D rectangle = new Rectangle2D.Float(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
		if (oval.intersects(rectangle)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the Brick, the ball collides with, if there is one.
	 * @param grid
	 * @return
	 */
	public Brick intersects(Grid grid) {
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.size, (float)this.size);
		for (int i=0; i<grid.getArrayLenghtD1(); i++) {
			for (int j=0; j<grid.getArrayLenghtD2(); j++) {
				if (oval.intersects(new Rectangle2D.Float( grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight()))) {
					if (grid.getBrick(i, j).isVisible()) {
						return grid.getBrick(i, j);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the Brick, the ball collides with, if there is a second one.
	 * @param grid
	 * @param brick, the current brick, witch already intersects the ball.
	 * @return
	 */
	public Brick intersectsSecond(Grid grid,Brick brick) {
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.size, (float)this.size);
		for (int i=0; i<grid.getArrayLenghtD1(); i++) {
			for (int j=0; j<grid.getArrayLenghtD2(); j++) {
				if (oval.intersects(new Rectangle2D.Float( grid.getBrick(i, j).getX(), grid.getBrick(i, j).getY(), grid.getBrick(i, j).getWidth(), grid.getBrick(i, j).getHeight()))) {
					if (grid.getBrick(i, j).isVisible()) {
						if(brick != grid.getBrick(i, j)) {
							return grid.getBrick(i, j);
						}
					}
				}
			}
		}
		return null;
	}
	
	//Getter and Setter:
	
	/**
	 * Returns the x-coordinate of the ball's center.
	 * @return
	 */
	public double getMiddleX() {
		return this.getX()+this.getSize()/2;
	}
	/**
	 * Returns the Y-coordinate of the ball's center.
	 * @return
	 */
	public double getMiddleY() {
		return this.getY()+this.getSize()/2;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * @return the panelWidth
	 */
	public int getPanelWidth() {
		return panelWidth;
	}

	/**
	 * @param panelWidth the panelWidth to set
	 */
	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}

	/**
	 * @return the panelHeight
	 */
	public int getPanelHeight() {
		return panelHeight;
	}

	/**
	 * @param panelHeight the panelHeight to set
	 */
	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	
}
