package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution53 {
  public int maxSubArray(int[] A) {
    if (A == null || A.length == 0) return 0;
    int n = A.length;
    int[] dp = new int[n];
    dp[0] = A[0];

    int max = dp[0];
    for (int i = 1; i < n; i++) {
      dp[i] = A[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  @Test
  public void test1() {
    assertEquals(maxSubArray(new int[] {1, 2, 3}), 6);
  }
}
