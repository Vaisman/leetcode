package medium;

import java.util.HashSet;
import java.util.Set;

public class Solution681 {
  public String nextClosestTime(String time) {
    String[] val = time.split(":");
    Set<Integer> set = new HashSet<>();
    int hour = add(set, val[0]);
    int minu = add(set, val[1]);

    int[] times = new int[] {hour, minu};
    nxt(times);

    while (!contains(times[0], times[1], set)) {
      nxt(times);
    }
    return valid(times[0]) + ":" + valid(times[1]);
  }

  void nxt(int[] time) {
    int hour = time[0];
    int minu = time[1];
    minu++;
    if (minu == 60) {
      hour++;
      minu = 0;
      if (hour == 24) hour = 0;
    }
    time[0] = hour;
    time[1] = minu;
  }

  int add(Set<Integer> set, String timeStr) {
    int time = Integer.parseInt(timeStr);
    set.add(time / 10);
    set.add(time % 10);
    return time;
  }

  String valid(int time) {
    if (time >= 0 && time <= 9) return "0" + time;
    else return time + "";
  }

  public boolean contains(int hour, int minu, Set<Integer> set) {
    return set.contains(hour / 10)
        && set.contains(hour % 10)
        && set.contains(minu / 10)
        && set.contains(minu % 10);
  }
}
