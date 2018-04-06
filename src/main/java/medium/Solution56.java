package medium;

import common.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
  public List<Interval> merge(List<Interval> intervals) {
    int n = intervals.size();
    int[] start = new int[n];
    int[] end = new int[n];

    for (int i = 0; i < n; i++) {
      start[i] = intervals.get(i).start;
      end[i] = intervals.get(i).end;
    }

    Arrays.sort(start);
    Arrays.sort(end);

    List<Interval> list = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < n && j < n) {
      if (j == n - 1 || end[j] < start[j + 1]) {
        list.add(new Interval(start[i], end[j]));
        i = j + 1;
      }
      j++;
    }

    return list;
  }

  @Test
  public void test() {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(1, 3));
    intervals.add(new Interval(2, 6));
    intervals.add(new Interval(8, 10));
    intervals.add(new Interval(15, 18));
    merge(intervals);
  }
}
