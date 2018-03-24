package zero;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution22 {
  public int countBinarySubstrings(String s) {
    if (s == null || s.length() == 0) return 0;

    List<Integer> list = new ArrayList<>();
    int counter = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        counter++;
      } else {
        list.add(counter);
        counter = 1;
      }
    }
    list.add(counter);

    int res = 0;
    for (int i = 1; i < list.size(); i++) {
      res += Math.min(list.get(i), list.get(i - 1));
    }
    return res;
  }

  @Test
  public void test() {
    assertEquals(3, countBinarySubstrings("000111"));
    assertEquals(1, countBinarySubstrings("01"));
  }
}
