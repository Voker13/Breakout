package model;



public class Bar {
	/**
	 * The ball's actual x-Coordinate
	 */
	private int x;
	/**
	 * The ball's actual y-Coordinate
	 */
	private int y;
	/**
	 * The ball's actual width
	 */
	private final int width = 100;
	/**
	 * The ball's actual height
	 */
	private final int height = 5;
	/**
	 * The panel's actual width
	 */
	private int panelWidth;
	/**
	 * The panel's actual height
	 */
	private int panelHeight;
	/**
	 * Creates a new Bar and calculates its starting-position from the panel's size.
	 * @param panelWidth
	 * @param panelHeight
	 */
	public Bar(int panelWidth ,int panelHeight) {
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		x = panelWidth/2 - width/2;
		y = panelHeight - panelHeight/10;
		
	}
	/**
	 * Sets this bar's x-Coordinate to the new value, corresponding to the entered one.
	 * Uses borders of the panel and the bar's width for the calculation.
	 * @param x
	 */
	public void doLogic(int x) {
		this.setX(x-this.getWidth()/2);
		if (this.getX() <= 0 ) {
			this.setX(0);
		}
		if (this.getX() >= panelWidth - this.getWidth()) {
			this.setX(panelWidth - this.getWidth());
		}
	}
	/**
	 * Returnes the bar's current x-Coordinate.
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets the bar's x-coordinate to the given value.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Returnes the bar's current y-Coordinate.
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Sets the bar's y-coordinate to the given value.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Returnes the bar's current width.
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returnes the bar's current height.
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Returns the panel's actual width.
	 */
	public int getPanelWidth() {
		return panelWidth;
	}
	/**
	 * Sets the panel's width to the given value.
	 */
	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}
	/**
	 * Returns the panel's actual height.
	 */
	public int getPanelHeight() {
		return panelHeight;
	}
	/**
	 * Sets the panel's height to the given value.
	 */
	public void setPanelHeight(int panelHeight) {
		this.panelHeight = panelHeight;
	}

	
}
