package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution83 {
  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) return false;

    int rev = 0;
    while (x > rev) {
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    return (x == rev || x == rev / 10);
  }

  @Test
  public void test() {
    assertEquals(isPalindrome(121), true);
    assertEquals(isPalindrome(1001), true);
    assertEquals(isPalindrome(100), false);
    assertEquals(isPalindrome(Integer.MAX_VALUE), false);
  }
}
