package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution221 {
  public int maximalSquare(char[][] matrix) {

    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[] dp = new int[cols + 1];
    int maxsLen = 0;
    int prev = 0;

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
          maxsLen = Math.max(maxsLen, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }
    return maxsLen * maxsLen;
  }

  @Test
  public void test() {
    assertEquals(
        maximalSquare(
            new char[][] {
              {'1', '0', '1', '0', '0'},
              {'1', '0', '1', '1', '1'},
              {'1', '1', '1', '1', '1'},
              {'1', '0', '0', '1', '0'}
            }),
        4);
  }
}
