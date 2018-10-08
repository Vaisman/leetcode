package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution750 {
  public int countCornerRectangles(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[n][n];
    int res = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (grid[i][j] == 1) {
          for (int k = j + 1; k < n; k++) {
            if (grid[i][k] == 1) {
              res += dp[j][k];
              dp[j][k]++;
            }
          }
        }
      }
    }

    return res;
  }

  @Test
  public void test() {
   // assertEquals(countCornerRectangles(new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}), 9);
    assertEquals(
        countCornerRectangles(
            new int[][] {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}}),
        1);
  }
}
