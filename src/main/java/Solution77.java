import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution77 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    combine(res, new ArrayList<>(), candidates, 0, target);
    return res;
  }

  private void combine(
      List<List<Integer>> res, ArrayList<Integer> comb, int[] candidate, int start, int target) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      List<Integer> r = new ArrayList<>(comb);
      if (!res.contains(r)) {
        res.add(r);
      }
      return;
    }

    for (int i = start; i <= candidate.length - 1; i++) {
      comb.add(candidate[i]);
      combine(res, comb, candidate, start + 1, target - candidate[i]);
      comb.remove(comb.size() - 1);
    }
  }

  @Test
  public void test() {
    combinationSum(new int[] {2, 3, 6, 7}, 7);
  }
}
