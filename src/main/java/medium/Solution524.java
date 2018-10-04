package medium;

import java.util.Collections;
import java.util.List;

public class Solution524 {
  public String findLongestWord(String s, List<String> d) {

    Collections.sort(
        d,
        (a, b) ->
            a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));

    for (String str : d) {
      if (isSubsequence(str, s)) return str;
    }

    return "";
  }

  private boolean isSubsequence(String x, String y) {
    int j = 0;
    for (int i = 0; i < y.length() && j < x.length(); i++) {
      if (x.charAt(j) == y.charAt(i)) j++;
    }
    return j == x.length();
  }
}
