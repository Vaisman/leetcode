import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution80 {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;

    for (int i = 0; i < flowerbed.length && count <= n; i++) {
      if (flowerbed[i] == 0) {
        int left = (i - 1 >= 0) ? flowerbed[i - 1] : 0;
        int right = (i + 1 < flowerbed.length) ? flowerbed[i + 1] : 0;
        if (left == 0 && right == 0) {
          flowerbed[i] = 1;
          count++;
        }
      }
    }

    return count >= n;
  }

  @Test
  public void test() {
    assertEquals(canPlaceFlowers(new int[] {0, 0, 1, 0, 0}, 1), true);
    assertEquals(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1), true);
    assertEquals(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2), false);
    assertEquals(canPlaceFlowers(new int[] {1, 0, 0, 0, 0, 1}, 2), false);
  }
}
