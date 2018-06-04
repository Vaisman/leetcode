package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution791 {
  public String customSortString(String S, String T) {
    int[] count = new int[26];
    for (char c : T.toCharArray()) {
      ++count[c - 'a'];
    }

    StringBuilder sb = new StringBuilder();
    for (char c : S.toCharArray()) {
      while (count[c - 'a']-- > 0) {
        sb.append(c);
      } // sort chars both in T and S by the order of S.
    }

    for (char c = 'a'; c <= 'z'; ++c) {
      while (count[c - 'a']-- > 0) {
        sb.append(c);
      } // group chars in T but not in S.
    }

    return sb.toString();
  }

  @Test
  public void test() {
    assertEquals(customSortString("cba", "abcd"), "cbad");
  }
}
