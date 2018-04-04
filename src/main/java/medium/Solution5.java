package medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution5 {
  private int lo, maxLen;

  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) return s;

    for (int i = 0; i < len - 1; i++) {
      extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
      extendPalindrome(s, i, i + 1); // assume even length.
    }
    return s.substring(lo, lo + maxLen);
  }

  private void extendPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }
    if (maxLen < k - j - 1) {
      lo = j + 1;
      maxLen = k - j - 1;
    }
  }

  public String longestPalindrome1(String str) {
    Map<Character, Integer> charIndex = new HashMap();
    int maxLength = 0;
    int startIndex = 0;
    int endIndex = 0;

    for (int i = 0; i < str.length(); i++) {
      Integer oldIndex = charIndex.get(str.charAt(i));
      if (null != oldIndex && oldIndex >= startIndex) {
        if (maxLength < i - oldIndex + 1) {
          maxLength = i - oldIndex + 1;
          endIndex = i;
          startIndex = oldIndex;
        }
      }
      charIndex.put(str.charAt(i), i);
    }
    return str.substring(startIndex, endIndex + 1);
  }

  @Test
  public void test() {
    assertEquals(longestPalindrome("cbbd"), "bb");
    assertEquals(longestPalindrome1("cbbd"), "bb");
  }
}
