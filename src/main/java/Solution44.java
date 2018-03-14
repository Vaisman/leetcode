import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution44 {
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    if (target < nums[0]) {
      return 0;
    }

    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l++;
      } else {
        r--;
      }
    }

    return l;
  }

  @Test
  public void test() {
    assertEquals(2, searchInsert(new int[] {1, 2, 3, 4, 5}, 3));
    assertEquals(1, searchInsert(new int[] {1, 3, 5, 6}, 2));
  }
}
