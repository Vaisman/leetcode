package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution79 {
  public int lengthOfLastWord(String s) {
    int len = s.length() - 1;
    int lastLength = 0;

    // trim
    while (len >= 0 && s.charAt(len) == ' ') {
      len--;
    }

    // calculate
    while (len >= 0 && s.charAt(len) != ' ') {
      lastLength++;
      len--;
    }

    return lastLength;
  }

  @Test
  public void test() {
    assertEquals(lengthOfLastWord("Hello World"), 5);
    assertEquals(lengthOfLastWord("Hello"), 5);
    assertEquals(lengthOfLastWord("Hello "), 1);
  }
}
