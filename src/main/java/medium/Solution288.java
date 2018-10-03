package medium;

public class Solution288 {
  class ValidWordAbbr {
    private final String[] dict;

    public ValidWordAbbr(String[] dictionary) {
      dict = dictionary;
    }

    public boolean isUnique(String word) {
      int n = word.length();
      for (String s : dict) {
        if (word.equals(s)) {
          continue;
        }
        int m = s.length();
        if (m == n && s.charAt(0) == word.charAt(0) && s.charAt(m - 1) == word.charAt(n - 1)) {
          return false;
        }
      }
      return true;
    }
  }
}
