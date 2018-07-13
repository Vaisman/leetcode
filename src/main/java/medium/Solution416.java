package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        // Since the problem is a 0-1 backpack problem, we only have two choices which are take or not.
        // Thus in this problem, by using the sum value as the index of DP array, we transfer the problem
        // to "whether should we take the currently visited number into the sum or not".
        // To construct the DP recurrence, when we are visiting nums[i] and to find partition of sum j:
        // if we do not take the nums[i], then the current iteration does not make any difference on current DP value
        // if we take the nums[i], then we need to find whether the (new_sum = j - nums[i]) can be constructed.
        // If any of this two construction can work, the partition of sum == j can be reached.

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

  public boolean canPartition1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (sum % 2 != 0) return false;
    int[] dp = new int[sum / 2];

    return doDp(sum / 2, 0, 0, nums, dp);
  }

  public boolean doDp(int max, int cur, int index, int[] nums, int[] dp) {
    if (cur > max || index >= nums.length) {
      return false;
    } else if (cur == max) {
      return true;
    }
    if (dp[cur] == 1) {
      return true;
    } else if (dp[cur] == -1) {
      return false;
    }
    boolean res =
        doDp(max, cur + nums[index], index + 1, nums, dp) || doDp(max, cur, index + 1, nums, dp);
    dp[cur] = res ? 1 : -1;
    return res;
  }

  @Test
  public void test() {
    assertEquals(canPartition(new int[] {1, 5, 11, 5}), true);
  }
}
