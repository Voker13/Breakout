import java.awt.Color;

public class Brick {
	
	private Color color;
	private final int width = 38;
	private final int height = 18;
	private int x;
	private int y;
	private boolean visible = true;
	
	public Brick(Grid g, int x, int y, Color color) {
		this.color = color;
		this.x = 1+x*(width+2);
		this.y = 31+y*(height+2);
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
