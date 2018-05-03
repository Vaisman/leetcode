package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));

    List<int[]> res = new ArrayList<>();

    for (int[] p : people) {
      res.add(p[1], p);
    }

    return res.toArray(new int[0][0]);
  }

  @Test
  public void test() {
    reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
  }
}
