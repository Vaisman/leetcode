package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution540 {

  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      if ((mid % 2 == 0 && mid + 1 < n && nums[mid] == nums[mid + 1])
          || (mid % 2 == 1 && mid - 1 >= 0 && nums[mid] == nums[mid - 1])) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return nums[lo];
  }

  public int singleNonDuplicate1(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length % 2 == 0) return 0;

    if (nums.length == 1) return nums[0];

    for (int i = 0; i <= nums.length - 1; i += 2) {
      if (i == nums.length-1) return nums[i];

      if (nums[i] == nums[i + 1]) {
        continue;
      } else {
        return nums[i];
      }
    }
    return 0;
  }

  @Test
  public void test() {
    assertEquals(singleNonDuplicate1(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}), 2);
    assertEquals(singleNonDuplicate1(new int[] {1, 1, 2}), 2);
  }
}
