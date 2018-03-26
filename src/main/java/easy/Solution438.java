package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;

    int[] hash = new int[255];
    for (char c : p.toCharArray()) {
      hash[c]++;
    }

    int count = p.length();
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      if (hash[s.charAt(right)] > 0) {
        count--;
      }
      hash[s.charAt(right)]--;
      right++;

      if (count == 0) {
        res.add(left);
      }

      if (right - left == p.length()) {
        if (hash[s.charAt(left)] >= 0) {
          count++;
        }
        hash[s.charAt(left)]++;
        left++;
      }
    }

    return res;
  }

  @Test
  public void test1() {
    findAnagrams("cbaebabacd", "abc");
  }
}
