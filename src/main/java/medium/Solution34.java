package medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution34 {
  private int extremeInsertionIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (nums[mid] > target || (left && target == nums[mid])) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public int[] searchRange(int[] nums, int target) {
    int[] targetRange = {-1, -1};

    int leftIdx = extremeInsertionIndex(nums, target, true);

    if (leftIdx == nums.length || nums[leftIdx] != target) {
      return targetRange;
    }

    targetRange[0] = leftIdx;
    targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
    return targetRange;
  }

  @Test
  public void test() {
    assertArrayEquals(searchRange(new int[] {4, 5, 6, 7, 0, 1, 2}, 1), new int[] {-1, -1});
  }
}
