import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution57 {
  public static boolean isMetatheses(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int count = 0;
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        count++;
      }
    }

    return count == 2;
  }

  @Test
  public void test() {
    assertEquals(true, isMetatheses("converse", "conserve"));
  }
}
