// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 */
	public CharGrid(char[][] grid) {
        this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int rows = grid.length;
        int cols = grid[0].length;
        int maxCol = -1;
        int maxRow = -1;
        int minCol = Integer.MAX_VALUE;
        int minRow = Integer.MAX_VALUE;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == ch) {
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                    maxCol = Math.max(maxCol, j);
                    minCol = Math.min(minCol, j);
                }
            }
        }
        if (maxCol == -1) {
            return 0;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol +1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int k;
                int left = 0;
                k = j - 1;
                while (k >= 0 && grid[i][k] == grid[i][j]) {
                    ++left;
                    --k;
                }
                int right = 0;
                k = j + 1;
                while (k < cols && grid[i][k] == grid[i][j]) {
                    ++right;
                    ++k;
                }
                int up = 0;
                k = i - 1;
                while (k >= 0 && grid[k][j] == grid[i][j]) {
                    ++up;
                    --k;
                }
                int down = 0;
                k = i + 1;
                while (k < rows && grid[k][j] == grid[i][j]) {
                    ++down;
                    ++k;
                }
                if(left > 0 && up == down && down == left && left == right) {
                    ++res;
                }
            }
        }
        return res;
	}
}
