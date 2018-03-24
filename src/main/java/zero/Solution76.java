package zero;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution76 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    combination(res, new ArrayList<>(), k, 1, n);
    return res;
  }

  public void combination(List<List<Integer>> res, List<Integer> comb, int k, int start, int n) {
    if (comb.size() == k && n == 0) {
      List<Integer> li = new ArrayList<>(comb);
      res.add(li);
    }
    for (int i = start; i <= n && i <= 9; i++) {
      comb.add(i);
      combination(res, comb, k, i + 1, n - i);
      comb.remove(comb.size() - 1);
    }
  }

  @Test
  public void test() {
    combinationSum3(2, 18);
  }
}
