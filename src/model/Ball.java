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
	
	public Ball(int x, int y, int panelWidth, int panelHeight) {
		this.x = x-SIZE/2;
		this.y = y-SIZE;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
	}

	public boolean intersects(Bar bar) {
		Shape oval = new Ellipse2D.Float((float)this.x, (float)this.y, (float)this.SIZE, (float)this.SIZE);
		Rectangle2D rectangle = new Rectangle2D.Float(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
		if (oval.intersects(rectangle)) {
			return true;
		}
		return false;
	}
	
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
	
	public void move() {
		x += Math.cos(angle*Math.PI/180)*this.getSPEED();
		y += Math.sin(angle*Math.PI/180)*this.getSPEED();
	}
	
	
	
	
	public void doBottomRightCornerBouncingLogic(int x, int y) {
		System.out.println(angle);
		double atan = Math.toDegrees(Math.atan(absValue(this.getMiddleY() - y) / absValue(this.getMiddleX() - x)));
		System.err.println("atan: "+atan);
		angle -= 2 * absValue(360 - atan - this.angle) + 180; // <-- falsch!! // TODO
		System.out.println(angle);
	}
	
	public void doBottomLeftCornerBouncingLogic(int x, int y) {
		System.out.println(angle);
		double atan = Math.toDegrees(Math.atan(absValue(this.getMiddleY() - y) / absValue(this.getMiddleX() - x)));
		System.err.println("atan: "+atan);
		angle += 2 * absValue(360 - atan - this.angle) + 180; // <-- falsch!! // TODO
		System.out.println(angle);
	}
	
	public void doRightLeftBounceLogic() {
		angle -= (angle-270)*2;
	}
	
	public void doTopBottomBounceLogic() {
		angle -= (angle-180)*2;
	}
	
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
	
	public double getMiddleX() {
		return this.getX()+this.getSize()/2;
	}

	public double getMiddleY() {
		return this.getY()+this.getSize()/2;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getSize() {
		return SIZE;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSPEED() {
		return Speed;
	}

	public void setSpeed(double speed) {
		Speed = speed;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
