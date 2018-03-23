import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Solution86 {
  public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;

    long avg = 0;
    for (int i = 0; i < k && i < nums.length; i++) {
      avg += nums[i];
    }
    long max = avg;

    for (int i = k; i < nums.length; i++) {
      avg += nums[i] - nums[i - k];
      max = Math.max(max, avg);
    }
    return max / 1.0 / k;
  }

  @Test
  public void test() {
    assertTrue(Math.abs(findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4) - 12.75) < 0.01);
  }
}
