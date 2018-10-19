package medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution370 {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] res = new int[length];
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] update : updates) {
      map.put(update[0], map.getOrDefault(update[0], 0) + update[2]);
      map.put(update[1] + 1, map.getOrDefault(update[1] + 1, 0) - update[2]);
    }

    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += map.getOrDefault(i, 0);
      res[i] = sum;
    }
    return res;
  }

  @Test
  public void test() {
    getModifiedArray(5, new int[][] {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
  }
}
