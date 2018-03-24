package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution39 {

  public boolean isPerfectSquare(int num) {
    int l = 1;
    int r = num;

    while (l < r) {
      long mid = (l + r) / 2;
      if (mid * mid == num) {
        return true;
      } else if (mid * mid < num) {
        l = (int)mid + 1;
      } else {
        r = (int)mid - 1;
      }
    }
    return false;
  }

  @Test
  public void test() {
    assertEquals(true, isPerfectSquare(16));
    assertEquals(false, isPerfectSquare(14));
  }
}
