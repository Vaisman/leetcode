package medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution17 {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> res = new LinkedList<>();
    if (digits == null || digits.length() == 0) return res;
    String[] map =
        new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    res.add("");

    for (int i = 0; i < digits.length(); i++) {
      int x = digits.charAt(i) - '0';

      while (res.peek().length() == i) {
        String t = res.remove();
        for (char s : map[x].toCharArray()) {
          res.add(t + s);
        }
      }
    }

    return res;
  }

  @Test
  public void test() {
    letterCombinations("23");
  }
}
