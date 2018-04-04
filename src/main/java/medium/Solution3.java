package medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    Set<Character> window = new HashSet<>();
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!window.add(c)) { // Found dup, shrink window until found same one
        for (int j = i - window.size(); c != s.charAt(j); j++) {
          window.remove(s.charAt(j));
        }
      }
      max = Math.max(max, window.size());
    }

    return max;
  }

  @Test
  public void test() {
    assertEquals(lengthOfLongestSubstring("dvxdf"), 4);
    assertEquals(lengthOfLongestSubstring("abcabcabc"), 3);
    assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
    assertEquals(lengthOfLongestSubstring("adbccba"), 4);
  }
}
