package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution64 {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] minSum = new int[m][n];
    minSum[0][0] = grid[0][0];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j > 0) {
          minSum[i][j] = minSum[i][j - 1] + grid[i][j];
        } else if (j == 0 && i > 0) {
          minSum[i][j] = minSum[i - 1][j] + grid[i][j];
        } else if (i > 0 && j > 0) {
          minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
        }
      }
    }

    return minSum[m - 1][n - 1];
  }

  @Test
  public void test() {
    assertEquals(minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}), 7);
  }
}