/**
 * 1254. Number of Closed Islands
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class NumberOfClosedIslands {
  static final int LAND = 0;
  int rows, cols;
  int[][] grid;
  boolean[][] visited;

  private boolean isWater(int row, int col) {
    return grid[row][col] != LAND;
  }

  private boolean isClosed(int row, int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) return false;

    // water is wet
    if (isWater(row, col)) return true;

    // land on edge
    if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) return false;

    // internal land is closed by default
    if (visited[row][col]) return true;
    visited[row][col] = true;

    boolean closed = isClosed(row - 1, col);
    closed &= isClosed(row + 1, col);
    closed &= isClosed(row, col - 1);
    closed &= isClosed(row, col + 1);

    return closed;
  }

  public int closedIsland(int[][] g) {
    grid = g;
    rows = grid.length;
    cols = grid[0].length;

    visited = new boolean[rows][];
    for (int i = 0; i < rows; i++) {
      visited[i] = new boolean[cols];
    }

    int numberOfClosedIslands = 0;
    for (int i = 1; i < rows - 1; i++) {
      for (int j = 1; j < cols - 1; j++) {
        if (!visited[i][j] && grid[i][j] == 0 && isClosed(i, j)) {
          numberOfClosedIslands += 1;
        }
      }
    }

    return numberOfClosedIslands;
  }
}
