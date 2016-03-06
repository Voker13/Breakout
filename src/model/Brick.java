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
	private final int width = 28;
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
			case 0: red = 000; green = 000; blue = 000; hardiness = -1; score = 0; visible = false; break; //invis
			case 1: red = 200; green = 200; blue = 200; hardiness = -1; score = 0; break; //black
			case 2: red = 000; green = 000; blue = 255; hardiness = 1; score = 10; break; //blue
			case 3: red = 000; green = 255; blue = 000; hardiness = 2; score = 20; break; //green
			case 4: red = 255; green = 255; blue = 000; hardiness = 3; score = 30; break; //yellow
			case 5: red = 255; green = 140; blue = 000; hardiness = 4; score = 40; break; //orange
			case 6: red = 255; green = 000; blue = 000; hardiness = 5; score = 50; break; //red
			case 7: red = 255; green = 000; blue = 255; hardiness = 6; score = 60; break; //magenta
			case 8: red = 255; green = 020; blue = 147; hardiness = 7; score = 70; break; //pink
			case 9: red = 000; green = 255; blue = 255; hardiness = 8; score = 80; break; //cyan
			case 10: red = 100; green = 100; blue = 100; hardiness = 9; score = 90; break; //gray
			default: red = 200; green = 200; blue = 200; hardiness = -1; score = 0; break; //drakgray
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
		if (this.getIndex() != 1) {
			this.alpha = alpha;
			createCurrentColor();
		}
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
		if (this.getIndex() != 1) {
			this.red = red;
			createCurrentColor();
		}
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
		if (this.getIndex() != 1) {
			this.green = green;
			createCurrentColor();
		}
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
		if (this.getIndex() != 1) {
			this.blue = blue;
			createCurrentColor();
		}
	}

}
