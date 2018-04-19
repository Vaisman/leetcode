package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution647 {
  int count = 0;

  public int countSubstrings(String s) {

    for (int i = 0; i < s.length(); i++) {
      checkIsPalindrome(s, i, i); // odd
      checkIsPalindrome(s, i, i + 1); // even
    }

    return count;
  }

  private void checkIsPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
  }

  @Test
  public void test() {
    assertEquals(countSubstrings("aaa"), 6);
  }
}
