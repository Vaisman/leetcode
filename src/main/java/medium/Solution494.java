package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution494 {
  private int count = 0;

  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null || nums.length == 0) return 0;

    traverse(nums, S, 0, 0);
    return count;
  }

  private void traverse(int[] nums, int S, int sum, int index) {
    if ((sum == S) && (index == nums.length)) {
      count++;
    } else {
      traverse(nums, S, sum + nums[index], index + 1);
      traverse(nums, S, sum - nums[index], index + 1);
    }
  }

  @Test
  public void test() {
    assertEquals(findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3), 5);
  }
}
