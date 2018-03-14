import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution40 {
  public String convertToBase7(int num) {
    if (num == 0) return "0";

    StringBuilder res = new StringBuilder();
    boolean isPositive = true;
    if (num < 0) {
      num = -num;
      isPositive = false;
    }

    while (num != 0) {
      res.append(num % 7);
      num = num / 7;
    }
    if (!isPositive) {
      res.append("-");
    }

    return res.reverse().toString();
  }

  @Test
  public void test() {
    assertEquals("0", convertToBase7(0));
    assertEquals("1", convertToBase7(1));
    assertEquals("2", convertToBase7(2));
    assertEquals("3", convertToBase7(3));
    assertEquals("4", convertToBase7(4));
    assertEquals("5", convertToBase7(5));
    assertEquals("6", convertToBase7(6));
    assertEquals("10", convertToBase7(7));
    assertEquals("202", convertToBase7(100));
    assertEquals("-10", convertToBase7(-7));
  }
}
