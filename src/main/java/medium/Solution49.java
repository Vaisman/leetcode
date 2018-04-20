package medium;

import org.junit.Test;

import java.util.*;

public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    if (strs == null || strs.length == 0) return res;

    Map<String, List<String>> ans = new HashMap<>();
    int[] count = new int[26];

    for (String s : strs) {
      Arrays.fill(count, 0);

      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append(count[i]);
      }

      String key = sb.toString();
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList<>());
      }

      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

  @Test
  public void test() {
    groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
  }
}
