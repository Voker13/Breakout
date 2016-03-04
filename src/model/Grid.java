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
	public void setBrick(Brick b) {
		this.grid[b.getPositionArrayX()][b.getPositionArrayY()] = b;
	}
	/**
	 * Fills this grid with the standard brick-formation.
	 * (Color swapping after each second row)
	 */
	public void fill(int level) {
		int[][] brickChar;
		switch(level) {
			case 0: {
				System.out.println("Level 1");
				brickChar = new int[][] {
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,2,2,2,2,2,2,2,2,0},
					new int[] {0,3,3,3,3,3,3,3,3,0},
					new int[] {0,2,2,2,2,2,2,2,2,0},
					new int[] {0,3,3,3,3,3,3,3,3,0},
					new int[] {0,2,2,2,2,2,2,2,2,0},
					new int[] {0,3,3,3,3,3,3,3,3,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0}
				};
				break;
			}
			case 1: {
				System.out.println("Level 2");
				brickChar = new int[][] {
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,5,0,0,0,0}
				};
				break;
			}
			default: {
				brickChar = new int[][] {
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0},
				};
				break;
			}
		}
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				this.grid[i][j] = new Brick( j, i, brickChar[i][j]);
			}
		}
	}
	
}
