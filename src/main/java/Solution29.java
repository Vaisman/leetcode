import org.junit.Test;

import static org.junit.Assert.*;

public class Solution29 {

  public int minMoves(int[] nums) {
    if (nums.length == 0) return 0;

    int min = nums[0];

    for (int n : nums) min = Math.min(min, n);

    int res = 0;

    for (int n : nums) res += n - min;

    return res;
  }

  @Test
  public void test() {

    assertEquals(3, minMoves(new int[] {1, 2, 3}));
  }
}
