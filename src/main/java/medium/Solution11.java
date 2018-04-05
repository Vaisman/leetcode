package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution11 {

  public int maxArea(int[] height) {
    int maxArea = 0;
    int l = 0;
    int r = height.length - 1;

    while (l < r) {
      maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
      if (height[l] < height[r]) {
        int curr = height[l];
        while (height[l] <= curr && (l < r)) {
          l++;
        }
      } else if (height[l] > height[r]) {
        int curr = height[r];
        while (height[r] >= curr && (l < r)) {
          r--;
        }
      } else {
        int curr = height[r];
        while (height[r] >= curr && (l < r)) {
          r--;
        }
        while (height[l] <= curr && (l < r)) {
          l++;
        }
      }
    }
    return maxArea;
  }

  @Test
  public void test() {
    assertEquals(maxArea(new int[] {1, 1}), 1);
    assertEquals(maxArea(new int[] {0, 2}), 0);
  }
}
