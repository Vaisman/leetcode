package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution447 {
  public int totalHammingDistance(int[] nums) {
    int res = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        res += getDistance(nums[i], nums[j]);
      }
    }
    return res;
  }

  private int getDistance(int i, int j) {
    int value = i ^ j;
    int count = 0;
    while (value > 0) {
      if ((value & 1) == 1) {
        count++;
      }
      value >>= 1;
    }
    return count;
  }

  public int totalHammingDistance1(int[] nums) {
    int res = 0;
    int n = nums.length;

    for (int j = 0; j < 32; j++) {
      int bitCount = 0;
      for (int i = 0; i < n; i++) {
        bitCount += (nums[i] >> j) & 1;
      }
      res += bitCount * (n - bitCount);
    }

    return res;
  }

  @Test
  public void test() {
    assertEquals(getDistance(0, 0), 0);
    assertEquals(getDistance(1, 1), 0);
    assertEquals(getDistance(1, 2), 2);
    assertEquals(getDistance(1, 3), 1);
    assertEquals(totalHammingDistance(new int[] {4, 14, 2}), 6);
    assertEquals(totalHammingDistance1(new int[] {4, 14, 2}), 6);
  }
}
