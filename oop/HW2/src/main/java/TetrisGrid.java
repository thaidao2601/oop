//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
	}

    public boolean fullBlock(int row) {
        for (int i = 0; i < grid.length; ++i) {
            if (!grid[i][row]) {
                return false;
            }
        }
        return true;
    }
	/**
	 * Does row-clearing on the grid (see handout).
	 */
    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;

        int currentRow = 0;
        while (currentRow < height) {
            if (fullBlock(currentRow)) {
                for (int y = currentRow; y < height - 1; y++) {
                    for (int x = 0; x < width; x++) {
                        grid[x][y] = grid[x][y + 1];
                    }
                }
                for (int x = 0; x < width; x++) {
                    grid[x][height - 1] = false;
                }
            }
            else {
                currentRow++;
            }
        }
    }
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
