package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution676 {
  class MagicDictionary {
    Map<Integer, ArrayList<String>> buckets;

    public MagicDictionary() {
      buckets = new HashMap();
    }

    public void buildDict(String[] words) {
      for (String word : words) {
        buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
      }
    }

    public boolean search(String word) {
      if (!buckets.containsKey(word.length())) return false;
      for (String candidate : buckets.get(word.length())) {
        int mismatch = 0;
        for (int i = 0; i < word.length(); ++i) {
          if (word.charAt(i) != candidate.charAt(i)) {
            if (++mismatch > 1) break;
          }
        }
        if (mismatch == 1) return true;
      }
      return false;
    }
  }
}
