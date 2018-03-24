package zero;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution63 {

  public int rob(int[] nums) {
    int n = nums.length;
    if (n < 2) {
      return n > 0 ? nums[0] : 0;
    }
    return Math.max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
  }

  int robber(int[] nums, int l, int r) {
    int prev = 0;
    int curr = 0;
    for (int i = l; i <= r; i++) {
      int temp = Math.max(prev + nums[i], curr);
      prev = curr;
      curr = temp;
    }
    return curr;
  }

  @Test
  public void test() {
    int[] res1 = {1, 2, 3};
    assertEquals(3, rob(res1));

    int[] res2 = {1, 2, 1, 1};
    assertEquals(3, rob(res2));
  }
}
