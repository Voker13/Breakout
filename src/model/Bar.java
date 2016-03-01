package model;



public class Bar {
	
	private int x;
	private int y;
	private final int width = 100;
	private final int height = 5;

	private int panelWidth;
	private int panelHeight;
	
	public Bar(int panelWidth ,int panelHeight) {
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		x = panelWidth/2 - width/2;
		y = panelHeight - panelHeight/10;
		
	}
	
	public void doLogic(int x) {
		this.setX(x-this.getWidth()/2);
		if (this.getX() <= 0 ) {
			this.setX(0);
		}
		if (this.getX() >= panelWidth - this.getWidth()) {
			this.setX(panelWidth - this.getWidth());
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
	
	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	
}
