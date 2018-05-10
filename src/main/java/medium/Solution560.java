package medium;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Solution560 {
  public int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  @Test
  public void test() {
    assertEquals(subarraySum(new int[] {1, 1, 1}, 2), 2);
  }
}
