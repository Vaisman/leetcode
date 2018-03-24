package zero;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Solution23 {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] arr = new int[26];
    for (int i = 0; i < magazine.length(); i++) {
      arr[magazine.charAt(i) - 'a']++;
    }
    for (int i = 0; i < ransomNote.length(); i++) {
      if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test() {
    assertTrue(canConstruct("aa", "abba"));
  }
}
