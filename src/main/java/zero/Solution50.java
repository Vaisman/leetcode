package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution50 {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;

    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

    for (int i = n - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        continue;
      }
      dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
    }

    return dp[0];
  }

  @Test
  public void test() {
    assertEquals(2, numDecodings("AB"));
  }
}
