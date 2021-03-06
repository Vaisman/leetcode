package zero;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Solution71 {

  public boolean wordPattern(String pattern, String str) {
    if (pattern == null || pattern.isEmpty()) return false;
    if (str == null || str.isEmpty()) return false;

    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();

    String[] splitted = str.split(" ");
    if (pattern.length() != splitted.length) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      if (!Objects.equals(map1.put(String.valueOf(pattern.charAt(i)), i), map2.put(splitted[i], i)))
        return false;
    }
    return true;
  }

  @Test
  public void test() {
    assertEquals(wordPattern("abba", "dog cat cat dog"), true);
    assertEquals(wordPattern("abba", "dog cat cat fish"), false);
    assertEquals(wordPattern("aaaa", "dog cat cat dog"), false);
    assertEquals(wordPattern("abba", "dog dog dog dog"), false);
    assertEquals(wordPattern("abc", "b c a"), true);
  }
}
