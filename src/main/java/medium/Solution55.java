package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution55 {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) return true;

    int position = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] >= position) {

      }
      position++;
    }
    return false;
  }

  @Test
  public void test() {
    assertEquals(canJump(new int[] {2, 3, 1, 1, 4}), true);
    assertEquals(canJump(new int[] {3, 2, 1, 0, 4}), false);
    assertEquals(canJump(new int[] {0, 2, 3}), false);
  }
}
