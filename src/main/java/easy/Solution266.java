package easy;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution266 {
  public boolean canPermutePalindrome(String s) {
    int[] map = new int[128];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i)]++;
      if (map[s.charAt(i)] % 2 == 0) count--;
      else count++;
    }
    return count <= 1;
  }

  @Test
  public void test1() {
    assertEquals(canPermutePalindrome("code"), false);
  }
}
