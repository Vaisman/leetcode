package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution674 {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    if (nums.length == 1) return 1;

    int last = nums[0];
    int count = 1;
    int maxCount = 1;

    for (int i = 1; i < nums.length; i++) {
      if ((nums[i] - last) > 0) {
        count++;
        maxCount = Math.max(count, maxCount);
      } else {
        count = 1;
      }
      last = nums[i];
    }
    return maxCount;
  }

  @Test
  public void test() {
    assertEquals(3, findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
  }
}
