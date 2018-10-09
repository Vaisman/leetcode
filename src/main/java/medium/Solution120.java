package medium;

import java.util.List;

public class Solution120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return triangle.get(0).get(0);
    }

    int[] dp = new int[triangle.size()];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = triangle.get(n - 1).get(i);
    }
    for (int i = n - 2; i >= 0; i--) {
      List<Integer> list = triangle.get(i);
      for (int j = 0; j <= i; j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
      }
    }
    return dp[0];
  }
}
