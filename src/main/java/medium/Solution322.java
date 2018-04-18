package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution322 {

  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];

    Arrays.fill(dp, max);

    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  @Test
  public void test() {
    assertEquals(coinChange(new int[] {1, 2, 3}, 6), 2);
    assertEquals(coinChange(new int[] {1, 3, 5}, 11), 3);
    assertEquals(coinChange(new int[] {}, 11), -1);
    assertEquals(coinChange(new int[] {1}, 11), 11);
    assertEquals(coinChange(new int[] {100}, 11), -1);
    assertEquals(coinChange(new int[] {5, 3}, 9), 3);
  }
}
