import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution51 {
  public int myAtoi(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int index = 0;
    int sign = 1;
    int total = 0;

    while (s.charAt(index) == ' ' && index < s.length()) {
      index++;
    }

    if (s.charAt(index) == '+' || s.charAt(index) == '-') {
      sign = s.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    while (index < s.length()) {
      int digit = s.charAt(index) - '0';
      if (digit < 0 || digit > 9) break;

      if (Integer.MAX_VALUE / 10 < total
          || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      total = 10 * total + digit;
      index++;
    }
    return total * sign;
  }

  @Test
  public void test() {
    assertEquals(11, myAtoi("11"));
    assertEquals(Integer.MAX_VALUE, myAtoi("2147483647"));
  }
}
