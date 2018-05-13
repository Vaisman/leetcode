package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution304 {
  private int[][] dp;

  public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
      }
    }

    int iMin = Math.min(row1, row2);
    int iMax = Math.max(row1, row2);

    int jMin = Math.min(col1, col2);
    int jMax = Math.max(col1, col2);

    return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
  }

  @Test
  public void test() {
    int[][] matrix =
        new int[][] {
          {3, 0, 1, 4, 2},
          {5, 6, 3, 2, 1},
          {1, 2, 0, 1, 5},
          {4, 1, 0, 1, 7},
          {1, 0, 3, 0, 5}
        };

    assertEquals(sumRegion(matrix, 2, 1, 4, 3), 8);
  }
}
