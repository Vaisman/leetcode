package hard;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class Solution683 {
  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> active = new TreeSet();
    int day = 0;
    for (int flower : flowers) {
      day++;
      active.add(flower);
      Integer lower = active.lower(flower);
      Integer higher = active.higher(flower);
      if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k)
        return day;
    }
    return -1;
  }

  @Test
  public void test() {
    assertEquals(kEmptySlots(new int[] {1, 3, 2}, 1), 2);
  }
}
