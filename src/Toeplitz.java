/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class Toeplitz {
  int[][] matrix;
  int m, n;

  private boolean diagonalIsEqual(int row, int col) {
    int ref = matrix[row][col];
    for (int i = row, j = col; i < m && j < n; i += 1, j += 1) {
      if (matrix[i][j] != ref) return false;
    }

    return true;
  }

  public boolean isToeplitzMatrix(int[][] grid) {
    matrix = grid;
    m = matrix.length;
    n = matrix[0].length;

    for (int j = n - 1; j >= 0; j--) {
      if (!diagonalIsEqual(0, j)) return false;
    }

    for (int i = m - 1; i > 0; i--) {
      if (!diagonalIsEqual(i, 0)) return false;
    }

    return true;
  }
}
