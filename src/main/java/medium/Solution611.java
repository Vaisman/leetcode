package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution611 {
  public int triangleNumber(int[] nums) {
    int result = 0;
    if (nums.length < 3) return result;

    Arrays.sort(nums);

    for (int i = 2; i < nums.length; i++) {
      int left = 0, right = i - 1;
      while (left < right) {
        if (nums[left] + nums[right] > nums[i]) {
          result += (right - left);
          right--;
        } else {
          left++;
        }
      }
    }

    return result;
  }

  @Test
  public void test() {
    assertEquals(triangleNumber(new int[] {2, 2, 3, 4}), 3);
  }
}
