package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution33 {
  public int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }

    // lo==hi is the index of the smallest value and also the number of places rotated.
    int rot = lo;
    lo = 0;
    hi = nums.length - 1;
    // The usual binary search and accounting for rotation.
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      int realmid = (mid + rot) % nums.length;
      if (nums[realmid] == target) return realmid;
      if (nums[realmid] < target) lo = mid + 1;
      else hi = mid - 1;
    }
    return -1;
  }

  @Test
  public void test() {
    assertEquals(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 1), 5);
  }
}
