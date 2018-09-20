package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class ATest1 {

  // Runtime complexity  O(n) - one loop
  // Worse runtime complexity O(2*n) - two loops
  // if numDileveries == numDestinations the complexity is O(2 * n) in general is O(n)
  // Space O(n) - all locations duplicates in Map plus distance, O(n+n/2)

  //   plan
  // - validate input
  // - calculate distance for every location
  // - put the distance in TreeMap (key: distance, value: location)
  // - iterate numDileveries distances from the map, add them to results

  List<List<Integer>> CXD(
      int numDestinations, List<List<Integer>> allLocations, int numDileveries) {
    List<List<Integer>> res = new ArrayList<>();
    if (allLocations == null || allLocations.isEmpty()) return res;

    if (numDestinations == 0 || numDileveries == 0 || numDileveries > numDestinations) return res;

    Map<Integer, List<Integer>> map = new TreeMap<>();

    for (List<Integer> allLocation : allLocations) {
      int x = allLocation.get(0);
      int y = allLocation.get(1);
      map.put(x * x + y * y, Arrays.asList(x, y));
    }

    int index = 0;
    for (Integer i : map.keySet()) {
      if (index++ == numDileveries) break;
      res.add(map.get(i));
    }
    return res;
  }

  @Test
  public void test() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, -3));
    data.add(Arrays.asList(1, 2));
    data.add(Arrays.asList(3, 4));

    List<List<Integer>> res = CXD(3, data, 1);
  }

  @Test
  public void test1() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(3, 6));
    data.add(Arrays.asList(2, 4));
    data.add(Arrays.asList(5, 3));
    data.add(Arrays.asList(2, 7));
    data.add(Arrays.asList(1, 8));
    data.add(Arrays.asList(7, 9));

    List<List<Integer>> res = CXD(3, data, 3);
  }
}
