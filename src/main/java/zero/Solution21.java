package zero;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution21 {
  public boolean checkPossibility(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    int count = 0;
    for (int i = 1; (i < nums.length) && count < 2; i++) {
      if (nums[i] < nums[i - 1]) {
        count++;
        if (i - 2 < 0 || nums[i - 2] <= nums[i])
          nums[i - 1] = nums[i]; // modify nums[i-1] of a priority
        else nums[i] = nums[i - 1]; // have to modify nums[i]
      }
    }

    return count < 2;
  }

  @Test
  public void test() {
    assertTrue(checkPossibility(new int[] {4, 1, 2}));
    assertFalse(checkPossibility(new int[] {3, 4, 2, 3}));
  }
}
