package model;
import java.awt.Color;

public class Grid {
	/**
	 * The array all of the grid's bricks are stored in.
	 */
	private Brick[][] grid;
	/**
	 * Constructs a new grid (10x10 Bricks)
	 */
	public Grid() {
		this.grid = new Brick[10][10];
	}
	/**
	 * Returnes the brick stored at the given location of the grid.
	 * @param x
	 * @param y
	 * @return
	 */
	public Brick getBrick(int x, int y) {
		return this.grid[x][y];
	}
	/**
	 * Sets the given brick {@code b} to the given location ({@code x},{@code y}) in the grid.
	 */
	public void setBrick(Brick b ,int x, int y) {
		this.grid[x][y] = b;
	}
	/**
	 * Fills this grid with the standard brick-formation.
	 * (Color swapping after each second row)
	 */
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
