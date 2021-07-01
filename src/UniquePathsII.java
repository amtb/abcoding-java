import java.util.HashMap;
import java.util.Map;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
  Map<String, Integer> cache;

  private String getKey(int row, int col) {
    return String.format("%d-%d", row, col);
  }

  private int countPath(int[][] grid, int row, int col) {
    String key = getKey(row, col);
    if (cache.containsKey(key)) return cache.get(key);

    int m = grid.length;
    int n = grid[0].length;

    if (row >= m || col >= n) return 0;
    if (grid[row][col] == 1) return 0;
    if (row == m - 1 && col == n - 1) return 1;

    int down = countPath(grid, row + 1, col);
    int left = countPath(grid, row, col + 1);

    cache.put(getKey(row + 1, col), down);
    cache.put(getKey(row, col + 1), left);

    return down + left;
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    cache = new HashMap<>();
    return countPath(obstacleGrid, 0, 0);
  }
}
