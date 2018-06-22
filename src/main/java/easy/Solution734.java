package easy;

import java.util.HashSet;
import java.util.Set;

public class Solution734 {
  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
      // check on null and empty and invalid data

      if (words1.length != words2.length) return false;

      Set<String> set = new HashSet<>();
      for(String[] pair: pairs){
          set.add(pair[0]+"#"+pair[i]);
      }
      for(int i = 0;i<words1.length;i++) {
          if (words1[i].equals(words2[i])) continue;
          if (set.contains(words1[i]+"#"+words2[i]) || set.contains(words2[i]+"#"+words1[i]))  continue;
          return false;

      }
      return true;
  }
}
