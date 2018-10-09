package medium;

public class Solution712 {
  public int minimumDeleteSum(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();
    int[][] dp = new int[a.length + 1][b.length + 1];

    for (int i = 0; i < a.length; i++) dp[i + 1][0] = dp[i][0] + a[i];
    for (int i = 0; i < b.length; i++) dp[0][i + 1] = dp[0][i] + b[i];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        if (a[i] == b[j]) dp[i + 1][j + 1] = dp[i][j];
        else {
          int can1 = dp[i + 1][j] + b[j];
          int can2 = dp[i][j + 1] + a[i];
          dp[i + 1][j + 1] = Math.min(can1, can2);
        }
      }
    }
    return dp[a.length][b.length];
  }
}
