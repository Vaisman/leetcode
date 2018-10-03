package medium;

import java.util.HashSet;
import java.util.Set;

public class Solution792 {

  public int numMatchingSubseq(String S, String[] words) {
    int ans = 0;

    Set<String> valid = new HashSet<>();
    Set<String> invalid = new HashSet<>();

    for (String word : words) {
      if (valid.contains(word)) {
        ans++;
        continue;
      }
      if (invalid.contains(word)) {
        continue;
      } else if (isSubseq(S, word)) {
        valid.add(word);
        ans++;
      } else {
        invalid.add(word);
      }
    }
    return ans;
  }

  private boolean isSubseq(String S, String word) {
    int i = 0;
    int j = 0;
    while (i < S.length() && j < word.length()) {
      if (S.charAt(i) == word.charAt(j)) {
        i++;
        j++;
      } else {
        i++;
      }
    }

    return (j == word.length());
  }
}
