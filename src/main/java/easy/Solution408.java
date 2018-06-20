package easy;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Solution408 {
  public boolean validWordAbbreviation(String word, String abbr) {
    if (word == null || word.length() == 0 || abbr == null || abbr.length() == 0) return false;

    int i = 0, j = 0;
    while (i < word.length() && j < abbr.length()) {
      if (word.charAt(i) == abbr.charAt(j)) {
        ++i;
        ++j;
        continue;
      }

      // invalid characters
      if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
        return false;
      }

      int start = j;
      while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
        ++j;
      }

      int num = Integer.valueOf(abbr.substring(start, j));
      i += num;
    }

    return i == word.length() && j == abbr.length();
  }

  @Test
  public void test1() {
    assertTrue(validWordAbbreviation("abba", "a2a"));
  }
}
