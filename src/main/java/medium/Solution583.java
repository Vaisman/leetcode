package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution583 {
  public int minDistance1(String s1, String s2) {
    int[][] memo = new int[s1.length() + 1][s2.length() + 1];
    return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
  }

  int lcs(String s1, String s2, int m, int n, int[][] memo) {
    if (m == 0 || n == 0) {
      return 0;
    }

    if (memo[m][n] != 0) {
      return memo[m][n];
    }

    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
    } else {
      memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
    }
    return memo[m][n];
  }

  public int minDistance(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 || j == 0) continue;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
  }

  @Test
  public void test() {
    assertEquals(minDistance("sea", "eat"), 2);
  }
}
