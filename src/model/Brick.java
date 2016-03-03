package model;
import java.awt.Color;

public class Brick {
	/**
	 * This brick's individual color
	 */
	private Color color;
	/**
	 * This brick's individual width
	 */
	private final int width = 38;
	/**
	 * This brick's individual height
	 */
	private final int height = 18;
	/**
	 * This brick's individual x-Coordinate
	 */
	private int x;
	/**
	 * This brick's individual y-Coordinate
	 */
	private int y;
	/**
	 * Determines, whether the brick is visible or not
	 */
	private boolean visible = true;
	/**
	 * Creates a new instance with the following parameters:
	 * @param g			The Grid, in which the brick should be injected
	 * @param x 		x-Coordinate
	 * @param y 		y-Coordinate
	 * @param color 	The brick's color
	 */
	public Brick(Grid g, int x, int y, Color color) {
		this.color = color;
		this.x = 1+x*(width+2);
		this.y = 31+y*(height+2);
	}

	/**
	 * Returns the brick's color.
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Sets the brick's color to the given one.
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Returns the brick's actual width.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returns the brick's actual height.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Returns the brick's current x-Coordinate.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets the brick's x-Coordinate to the given value.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Returns the brick's current y-Coordinate.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Sets the brick's y-Coordinate to the given value.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns, whether the brick is actually visible (true) or not(false).
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Sets the brick visible(and collidable) or invisible(and uncollidable)
	 * @param visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
