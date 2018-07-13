package medium;

import org.junit.Test;

import java.util.*;

public class Solution347 {
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    TreeMap<Integer, List<Integer>> ordered = new TreeMap<>();

    for (int i : map.keySet()) {
      int freq = map.get(i);
      if (!ordered.containsKey(freq)) {
        ordered.put(freq, new ArrayList<>());
      }
      ordered.get(freq).add(i);
    }

    List<Integer> res = new ArrayList<>();
    while (res.size() < k) {
      Map.Entry<Integer, List<Integer>> entry = ordered.pollLastEntry();
      res.addAll(entry.getValue());
    }
    return res;
  }

  @Test
  public void test() {}
}
