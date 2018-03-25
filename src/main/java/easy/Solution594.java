package easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution594 {

  public int findLHS(int[] nums) {
    Arrays.sort(nums);

    int min = 0;
    int count = 0;

    for (int i = 1; i < nums.length; ) {
      if (nums[i] - nums[min] == 0) i++;
      else if (nums[i] - nums[min] == 1) {
        count = Math.max(count, i - min + 1);
        i++;
      } else min++;
    }
    return count;
  }

  @Test
  public void test() {
    assertEquals(5, findLHS(new int[] {1, 3, 2, 2, 5, 2, 3, 7}));
  }
}
