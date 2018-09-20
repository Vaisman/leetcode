package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
  List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); ++i) last[S.charAt(i) - 'a'] = i;

    int j = 0, anchor = 0;
    List<Integer> ans = new ArrayList();
    for (int i = 0; i < S.length(); ++i) {
      j = Math.max(j, last[S.charAt(i) - 'a']);
      if (i == j) {
        ans.add(i - anchor + 1);
        anchor = i + 1;
      }
    }
    return ans;
  }

  @Test
  public void test() {
    partitionLabels("abccad");
  }
}
