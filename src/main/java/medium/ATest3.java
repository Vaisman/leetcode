package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ATest3 {
  public List<Integer> cellCompete(int[] states, int days) {
    if (states == null || states.length == 0 || days < 0) return new ArrayList<>();

    for (int j = 0; j < days; j++) {
      int[] next = new int[states.length];

      if (states[1] == 0) next[0] = 0;
      if (states[1] == 1) next[0] = 1;

      if (states[states.length - 2] == 0) next[states.length - 1] = 0;
      if (states[states.length - 2] == 1) next[states.length - 1] = 1;

      for (int i = 1; i < states.length - 1; i++) {
        if ((states[i - 1] == 0 && states[i + 1] == 0)
            || (states[i - 1] == 1 && states[i + 1] == 1)) {
          next[i] = 0;
          continue;
        }

        if ((states[i - 1] == 0 && states[i + 1] == 1)
            || (states[i - 1] == 1 && states[i + 1] == 0)) {
          next[i] = 1;
        }
      }
      states = next;
    }

    List<Integer> res = new ArrayList<>();
    for (int state : states) {
      res.add(state);
    }
    return res;
  }

  @Test
  public void test1() {
    cellCompete(new int[] {1, 0, 0, 0, 0, 1, 0, 0}, 1);
    cellCompete(new int[] {1, 1, 1, 0, 1, 1, 1, 1}, 2);
  }
}
