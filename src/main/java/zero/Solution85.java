package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution85 {

  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int sum = 0;
    for (int n : nums) sum += n;

    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      sum -= nums[i];
      if (sum == left) return i;
      left += nums[i];
    }
    return -1;
  }

  @Test
  public void test() {
    assertEquals(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}), 3);
  }
}
