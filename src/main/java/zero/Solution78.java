package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution78 {
  public boolean validPalindrome(String s) {
    if (s == null || s.length() == 0) return true;
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) == s.charAt(end)) {
        start++;
        end--;
      } else {
        return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
      }
    }

    return true;
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) == s.charAt(end)) {
        start++;
        end--;
      } else {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test() {
    assertEquals(
        validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu"), true);
    assertEquals(validPalindrome("eeccccbebaeeabebccceea"), false);
    assertEquals(validPalindrome("aba"), true);
    assertEquals(validPalindrome("abat"), true);
    assertEquals(validPalindrome("sabat"), false);
  }
}
