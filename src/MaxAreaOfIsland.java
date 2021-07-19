/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
  static final int LAND = 1;

  private int markIslandAndGetArea(int[][] grid, int row, int col, boolean[][] visited) {

    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) return 0;
    if (visited[row][col]) return 0;
    if (grid[row][col] != LAND) return 0;

    visited[row][col] = true;
    return 1
      + markIslandAndGetArea(grid, row - 1, col, visited)
      + markIslandAndGetArea(grid, row + 1, col, visited)
      + markIslandAndGetArea(grid, row, col - 1, visited)
      + markIslandAndGetArea(grid, row, col + 1, visited);
  }

  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][];
    for (int i = 0; i < grid.length; i++) visited[i] = new boolean[grid[i].length];

    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == LAND) {
          max = Math.max(max, markIslandAndGetArea(grid, i, j, visited));
        }
      }
    }

    return max;
  }
}
