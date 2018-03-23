import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    if (nums == null || nums.length == 0) return false;

    Set<Integer> set = new HashSet<>(k + 1);
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }

    return false;
  }

  @Test
  public void test() {
    assertEquals(containsNearbyDuplicate(new int[] {-1, -1}, 1), true);
    assertEquals(containsNearbyDuplicate2(new int[] {-1, -1}, 1), true);
  }
}
