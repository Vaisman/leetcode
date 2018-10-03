package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution228 {
  public List<String> summaryRanges(int[] nums) {
    List<String> summary = new ArrayList<>();

    for (int i, j = 0; j < nums.length; ++j) {
      i = j;

      // try to extend the range [nums[i], nums[j]]
      while (j + 1 < nums.length && nums[j + 1] - nums[j] == 1) ++j;

      // put the range into the list
      if (i == j) summary.add(nums[i] + "");
      else summary.add(nums[i] + "->" + nums[j]);
    }

    return summary;
  }

  @Test
  public void test() {
    summaryRanges(new int[] {0, 1, 2, 4, 5});
  }
}
