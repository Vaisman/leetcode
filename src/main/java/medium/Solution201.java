package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution201 {
  public int rangeBitwiseAnd(int m, int n) {
    if (m == 0) {
      return 0;
    }

    int moveFactor = 1;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      moveFactor <<= 1;
    }

    return m * moveFactor;
  }

  @Test
  public void test() {
    assertEquals(rangeBitwiseAnd(5, 7), 4);
  }
}
