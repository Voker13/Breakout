


public class Bar {
	
	private int x;
	private final int y = 530;
	private final int width = 100;
	private final int height = 5;
	
	public Bar() {
		x = Gamepanel.PANELWIDTH/2 - width/2;
	}
	
	public void doLogic(int x) {
		this.setX(x-this.getWidth()/2);
		if (this.getX() <= 0 ) {
			this.setX(0);
		}
		if (this.getX() >= Gamepanel.PANELWIDTH - this.getWidth()) {
			this.setX(Gamepanel.PANELWIDTH - this.getWidth());
		}
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
