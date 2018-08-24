package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList();
    backtrack1(res, "", 0, 0, n);
    return res;
  }

  void backtrack1(List<String> res, String curr, int left, int right, int count) {
    if (curr.length() == count * 2) {
      res.add(curr);
      return;
    }

    if (left < count) backtrack1(res, curr + "(", left + 1, right, count);
    if (right < left) backtrack1(res, curr + ")", left, right + 1, count);
  }

  @Test
  public void test() {
    generateParenthesis(3);
  }
}
