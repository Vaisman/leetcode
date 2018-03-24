package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution45 {

  public boolean rotateString(String A, String B) {
    if (A.length() != B.length()) return false;

    int[] starts = new int[B.length()];
    char c = B.charAt(0);

    int index = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == c) {
        starts[index++] = i;
      }
    }

    for (int i = 0; i < index; i++) {
      if (helper(A, B, starts[i])) {
        return true;
      }
    }

    return false;
  }

  public boolean helper(String A, String B, int start) {
    if (start == A.length()) return false;

    int i = start;
    for (; i < A.length(); i++) {
      if (A.charAt(i) != B.charAt(i - start)) {
        return false;
      }
    }

    if (!A.substring(0, start).equals(B.substring(i - start, B.length()))) {
      return false;
    }

    return true;
  }

  @Test
  public void test() {
    assertEquals(true, rotateString("abcde", "cdeab"));
    assertEquals(false, rotateString("abcde", "abced"));
  }
}
