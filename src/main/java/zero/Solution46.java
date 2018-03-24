package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution46 {
  public int numTrees(int n) {

    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    int dp[] = new int[n + 1];

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] == 0) dp[i] = numTrees(i);
      if (dp[n - 1 - i] == 0) dp[n - 1 - i] = numTrees(n - 1 - i);

        count += dp[i] * dp[n - 1 - i];
    }
    return count;
  }

  @Test
  public void test() {
    assertEquals(5, numTrees(3));
    assertEquals(14, numTrees(4));
  }
}
