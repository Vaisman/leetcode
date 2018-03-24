package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution41 {

  char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  public String toHex(int num) {
    if (num == 0) return "0";
    String result = "";
    while (num != 0) {
      result = map[(num & 15)] + result;
      num >>>= 4;
    }
    return result;
  }

  @Test
  public void test() {
    assertEquals("0", toHex(0));
    assertEquals("2", toHex(2));
    assertEquals("9", toHex(9));
    assertEquals("a", toHex(10));
    assertEquals("1a", toHex(26));
    assertEquals("fffffff0", toHex(-16));
    assertEquals("10", toHex(16));
  }
}
