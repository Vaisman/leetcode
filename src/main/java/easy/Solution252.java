package easy;

import java.util.Arrays;

public class Solution252 {
  class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public boolean canAttendMeetings(Interval[] intervals) {
    int len = intervals.length;
    if (len == 0) {
      return true;
    }
    int[] begin = new int[len];
    int[] stop = new int[len];
    for (int i = 0; i < len; i++) {
      begin[i] = intervals[i].start;
      stop[i] = intervals[i].end;
    }
    Arrays.sort(begin);
    Arrays.sort(stop);
    int endT = 0;
    for (int i = 1; i < len; i++) {
      if (begin[i] < stop[i - 1]) {
        return false;
      }
    }
    return true;
  }
}
