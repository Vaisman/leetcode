package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution309 {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;
    int rest = 0, hold = Integer.MIN_VALUE, sold = Integer.MIN_VALUE;
    for (int price : prices) {
      int newHold = Math.max(hold, rest - price); // hold->hold, rest->hold
      rest = Math.max(rest, sold); // rest->rest, sold->rest
      sold = hold + price; // hold->sold
      hold = newHold;
    }
    return Math.max(rest, sold);
  }

  @Test
  public void test() {
    assertEquals(maxProfit(new int[] {1, 2, 3, 0, 2}), 3);
  }
}
