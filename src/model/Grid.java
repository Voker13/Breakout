package model;

public class Grid {
	/**
	 * The array all of the grid's bricks are stored in.
	 */
	private Brick[][] grid;
	private int arrayLenghtD1 = 13;
	private final int arrayLenghtD2 = 13;
	/**
	 * Constructs a new grid (10x10 Bricks)
	 */
	public Grid() {
		this.grid = new Brick[arrayLenghtD1][arrayLenghtD2];
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
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,3,0,0,0,0,0,3,0,0,0},
					new int[] {0,3,0,0,3,0,0,0,3,0,0,3,0},
					new int[] {0,3,0,3,3,3,3,3,3,3,0,3,0},
					new int[] {0,3,3,3,1,3,3,3,1,3,3,3,0},
					new int[] {0,3,3,3,3,3,3,3,3,3,3,3,0},
					new int[] {0,0,3,3,3,3,3,3,3,3,3,0,0},
					new int[] {0,0,0,3,0,0,0,0,0,3,0,0,0},
					new int[] {0,0,3,0,0,0,0,0,0,0,3,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0}
				};
				break;
			}
			case 1: {
				System.out.println("Level 2");
				brickChar = new int[][] {
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0}
				};
				break;
			}
			default: {
				brickChar = new int[][] {
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0},
					new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0}
				};
				break;
			}
		}
		for (int i=0; i<arrayLenghtD1; i++) {
			for (int j=0; j<arrayLenghtD2; j++) {
				this.grid[i][j] = new Brick( j, i, brickChar[i][j]);
			}
		}
	}
	
	public boolean isEmpty() {
		for (int i=0; i<arrayLenghtD1; i++) {
			for (int j=0; j<arrayLenghtD2; j++) {
				if (this.getBrick(i, j).getIndex() != 1 && this.getBrick(i, j).isVisible() == true) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * @return the arrayLenghtD1
	 */
	public int getArrayLenghtD1() {
		return arrayLenghtD1;
	}
	/**
	 * @param arrayLenghtD1 the arrayLenghtD1 to set
	 */
	public void setArrayLenghtD1(int arrayLenghtD1) {
		this.arrayLenghtD1 = arrayLenghtD1;
	}
	/**
	 * @return the arrayLenghtD2
	 */
	public int getArrayLenghtD2() {
		return arrayLenghtD2;
	}
	
}
