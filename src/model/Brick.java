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
	private int positionArrayX;
	private int positionArrayY;
	private int alpha = 255;
	private int red;
	private int green;
	private int blue;
	/**
	 * Determines, whether the brick is visible or not
	 */
	private boolean visible = true;
	/**
	 * Determines, how much points the user gets, when the brick was destroyed destroyed.
	 */
	private int score;
	/**
	 * Determines, how often the ball has to intersect the brick to get destroyed.
	 */
	private int hardiness;
	/**
	 * Creates a new instance with the following parameters:
	 * @param g			The Grid, in which the brick should be injected
	 * @param x 		x-Coordinate
	 * @param y 		y-Coordinate
	 * @param color 	The brick's color
	 */
	private int index;
	
	public Brick(int x, int y, int index) {
		this.x = 1+x*(width+2);
		this.y = 31+y*(height+2);
		this.positionArrayX = x;
		this.positionArrayY = y;
		this.index = index;
		switch(index) {
			case 0: red = 000; green = 000; blue = 000; hardiness = -1; score = 0; visible = false; break;
			case 1: red = 000; green = 000; blue = 255; hardiness = 1; score = 100; break;
			case 2: red = 000; green = 255; blue = 000; hardiness = 2; score = 200; break;
			case 3: color = Color.yellow; hardiness = 3; score = 300; break;
			case 4: color = Color.orange; hardiness = 4; score = 400; break;
			case 5: color = Color.red; hardiness = 5; score = 500; break;
			case 6: color = Color.magenta; hardiness = 6; score = 600; break;
			case 7: color = Color.pink; hardiness = 7; score = 700; break;
			case 8: color = Color.cyan; hardiness = 8; score = 800; break;
			case 9: color = Color.gray; hardiness = 9; score = 900; break;
			case 10: color = Color.black; hardiness = -1; score = 0; break;
			default: color = Color.darkGray; hardiness = -1; score = 0; break;
		}
		createCurrentColor();
	}
	
	private void createCurrentColor() {
		color = new Color(red,green,blue,alpha);
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

	/**
	 * @return the hardiness
	 */
	public int getHardiness() {
		return hardiness;
	}

	/**
	 * @param hardiness the hardiness to set
	 */
	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the positionArrayX
	 */
	public int getPositionArrayX() {
		return positionArrayX;
	}

	/**
	 * @param positionArrayX the positionArrayX to set
	 */
	public void setPositionArrayX(int positionArrayX) {
		this.positionArrayX = positionArrayX;
	}

	/**
	 * @return the positionArrayY
	 */
	public int getPositionArrayY() {
		return positionArrayY;
	}

	/**
	 * @param positionArrayY the positionArrayY to set
	 */
	public void setPositionArrayY(int positionArrayY) {
		this.positionArrayY = positionArrayY;
	}

	/**
	 * @return the alpha
	 */
	public int getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(int alpha) {
		this.alpha = alpha;
		createCurrentColor();
	}

	/**
	 * @return the red
	 */
	public int getRed() {
		return red;
	}

	/**
	 * @param red the red to set
	 */
	public void setRed(int red) {
		this.red = red;
		createCurrentColor();
	}

	/**
	 * @return the green
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * @param green the green to set
	 */
	public void setGreen(int green) {
		this.green = green;
		createCurrentColor();
	}

	/**
	 * @return the blue
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * @param blue the blue to set
	 */
	public void setBlue(int blue) {
		this.blue = blue;
		createCurrentColor();
	}

}
