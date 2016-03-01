import java.awt.Color;

public class Grid {
	
	private Brick[][] grid;
	
	public Grid() {
		this.grid = new Brick[10][10];
	}
	
	public Brick getBrick(int x, int y) {
		return this.grid[x][y];
	}
	
	public void setBrick(Brick b ,int x, int y) {
		this.grid[x][y] = b;
	}
	
	public void fill() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				Color c;
				switch(j) {
					case 0: c = Color.red;break;
					case 1: c = Color.red;break;
					case 2: c = Color.orange;break;
					case 3: c = Color.orange;break;
					case 4: c = Color.yellow;break;
					case 5: c = Color.yellow;break;
					case 6: c = Color.green;break;
					case 7: c = Color.green;break;
					case 8: c = Color.cyan;break;
					case 9: c = Color.cyan;break;
					default: c = Color.gray;break;
				}
				this.grid[i][j] = new Brick(this, i, j, c);
			}
		}
	}
	
}
