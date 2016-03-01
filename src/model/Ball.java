package model;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

	private double x;
	private double y;
	private final int SIZE = 10;
	private double Speed = 4;
	private double angle = 270;
	private boolean running = false;
	private int panelWidth;
	private int panelHeight;
	/**
	 * This constructor is used to create the standard-ball-object with the following parameters:
	 * @param x				-the x-coordinate
	 * @param y
	 * @param panelWidth
	 * @param panelHeight
	 */
	public Ball(int x, int y, int panelWidth, int panelHeight) {
		this.x = x-SIZE/2;
		this.y = y-SIZE;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
	}
	/**
	 * This method checks wether the ball collides with the bar and if so returns true.
	 * @param bar
	 * @return
	 */
	public boolean intersects(Bar bar) {
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.SIZE, (float)this.SIZE);
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
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.SIZE, (float)this.SIZE);
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
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
	 * This method moves the ball with the actual speed along the calculated angle.
	 */
	public void move() {
		x += Math.cos(angle*Math.PI/180)*this.getSPEED();
		y += Math.sin(angle*Math.PI/180)*this.getSPEED();
	}
	
	
	//TODO What does this method do?
	/**
	 *
	 * @param x
	 * @param y
	 */
	public void doBottomRightCornerBouncingLogic(int x, int y) {
		System.out.println(angle);
		double atan = Math.toDegrees(Math.atan(absValue(this.getMiddleY() - y) / absValue(this.getMiddleX() - x)));
		System.err.println("atan: "+atan);
		angle -= 2 * absValue(360 - atan - this.angle) + 180; // <-- falsch!! // TODO
		System.out.println(angle);
	}
	//TODO What does this method do?
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void doBottomLeftCornerBouncingLogic(int x, int y) {
		System.out.println(angle);
		double atan = Math.toDegrees(Math.atan(absValue(this.getMiddleY() - y) / absValue(this.getMiddleX() - x)));
		System.err.println("atan: "+atan);
		angle += 2 * absValue(360 - atan - this.angle) + 180; // <-- falsch!! // TODO
		System.out.println(angle);
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the sides.
	 */
	public void doRightLeftBounceLogic() {
		angle -= (angle-270)*2;
	}
	/**
	 * This method calculates the angle for the ball after bouncing from the top and bottom.
	 */
	public void doTopBottomBounceLogic() {
		angle -= (angle-180)*2;
	}
	/**
	 * This Method calculates the angle with the ball bounces from the bar, depending on the point hit.
	 * @param bar - The Object of the bar used.
	 */
	public void doBarBounceLogic(Bar bar) {
		double DeltaZ = (this.getMiddleX()) - (bar.getX());
		if (DeltaZ < 0) { DeltaZ = 0;}
		else if (DeltaZ > bar.getWidth()) { DeltaZ = bar.getWidth();}
		double OnePer = (((double)bar.getWidth())/100);
		double z = OnePer * DeltaZ /100;
		angle = 190+z*160.0;
	}
	
	private double absValue(double x) {
		if (x < 0) {return x*(-1);}
		return x;
	}
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
	 * Returns the x-coordinate at the top left edge of the ball.
	 * @return
	 */
	public double getX() {
		return x;
	}
	/**
	 * Returns the y-coordinate at the top left edge of the ball.
	 * @return
	 */
	public double getY() {
		return y;
	}
	/**
	 * Returns the balls size
	 */
	public int getSize() {
		return SIZE;
	}
	/**
	 * returns the balls angle
	 * @return
	 */
	public double getAngle() {
		return angle;
	}
	/**
	 * Sets the balls angle.
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	/**
	 * Returns the balls speed.
	 * @return
	 */
	public double getSPEED() {
		return Speed;
	}
	/**
	 * Sets the balls speed.
	 * @param speed
	 */
	public void setSpeed(double speed) {
		Speed = speed;
	}
	/**
	 * Sets the balls x-coordinate at the top left corner to the given value.
	 * @param x - the value to set to
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Sets the balls y-coordinate at the top left corner to the given value.
	 * @param y - the value to set to
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Returns true, if the ball is moving.
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * This should be set to true, as the ball starts moving and false on the opposite event.
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
}
