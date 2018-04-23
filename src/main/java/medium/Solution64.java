package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution64 {

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[] minSum = new int[m];
    minSum[0] = grid[0][0];

    for (int j = 1; j < n; j++) {
      minSum[j] = grid[0][j] + minSum[j - 1];
    }

    for (int i = 1; i < n; i++) {
      minSum[0] += grid[i][0];
      for (int j = 1; j < m; j++) {
        minSum[j] = Math.min(minSum[j - 1], minSum[j]) + grid[i][j];
      }
    }
    return minSum[m - 1];
  }

  @Test
  public void test() {
    assertEquals(minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}), 7);
  }
}
