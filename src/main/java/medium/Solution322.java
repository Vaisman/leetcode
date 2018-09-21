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

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
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
