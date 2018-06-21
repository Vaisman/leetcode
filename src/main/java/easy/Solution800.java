package easy;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution800 {
  public String similarRGB(String color) {
    return "#"
        + func(color.substring(1, 3))
        + func(color.substring(3, 5))
        + func(color.substring(5));
  }

  public String func(String comp) {
    int q = Integer.parseInt(comp, 16);
    q = q / 17 + (q % 17 > 8 ? 1 : 0);
    return String.format("%02x", 17 * q);
  }

  @Test
  public void test() {
    assertEquals(similarRGB("#09f166"), "#11ee66");
  }
}
