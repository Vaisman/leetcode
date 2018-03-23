import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution82 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0) return false;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) return true;
      }
      map.put(nums[i], i);
    }

    return false;
  }

  @Test
  public void test() {
    assertEquals(containsNearbyDuplicate(new int[] {-1, -1}, 1), true);
  }
}
