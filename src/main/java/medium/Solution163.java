package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution163 {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> list = new ArrayList<String>();
    if (nums == null) return list;
    int n = nums.length;
    for (int i = 0; i <= n; i++) {
      int lt = (i == 0) ? lower : nums[i - 1] + 1;
      int gt = (i == n) ? upper : nums[i] - 1;
      addRange(list, lt, gt);
    }
    return list;
  }

  private void addRange(List<String> list, int lo, int hi) {
    if (lo > hi) return;
    else if (lo == hi) list.add(String.valueOf(lo));
    else list.add(lo + "->" + hi);
  }
}
