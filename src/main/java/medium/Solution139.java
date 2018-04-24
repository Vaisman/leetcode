package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    return wordBreak(s, set);
  }

  public boolean wordBreak(String s, Set<String> wordDict) {
    if (s == null && wordDict == null) return true;
    if (s == null || wordDict == null) return false;

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String s1 = s.substring(j, i);
        if (dp[j] && wordDict.contains(s1)) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.length()];
  }

  @Test
  public void test() {
    List<String> s = new ArrayList<>();
    s.add("cats");
    s.add("dog");
    s.add("sand");
    s.add("and");
    s.add("cat");

    assertEquals(wordBreak("catsandog", s), false);
  }
}
