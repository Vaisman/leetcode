package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution300 {
  public int lengthOfLIS(int[] nums) {
    return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
  }

  private int lengthOfLIS(int[] nums, int prev, int curpos) {
    if (curpos == nums.length) {
      return 0;
    }

    int taken = 0;

    if (nums[curpos] > prev) {
      taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
    }

    int notTaken = lengthOfLIS(nums, prev, curpos + 1);
    return Math.max(taken, notTaken);
  }

  public int lengthOfLISDP(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxRes = 1;

    for (int i = 1; i < dp.length; i++) {

      int maxVal = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          maxVal = Math.max(maxVal, dp[j]);
        }
      }
      dp[i] = maxVal + 1;
      maxRes = Math.max(maxRes, dp[i]);
    }
    return maxRes;
  }

  @Test
  public void test() {
    assertEquals(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}), 4);
    assertEquals(lengthOfLISDP(new int[] {10, 9, 2, 5, 3, 7, 101, 18}), 4);
  }
}
