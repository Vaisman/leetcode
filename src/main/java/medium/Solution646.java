package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class Solution646 {
  public int findLongestChain(int[][] pairs) {
    if (pairs == null || pairs.length == 0) {
      return 0;
    }

    Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

    int[] dp = new int[pairs.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < pairs.length; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[j][1] < pairs[i][0]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return dp[pairs.length - 1];
  }

  @Test
  public void test() {
    assertEquals(findLongestChain(new int[][] {{1, 2}, {2, 3}, {3, 4}}), 2);
  }
}
