package screen.grab;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution0 {
  public int solution(int[] A) {
    // assume input valid

    Set<Integer> set = new HashSet<>();
    for (int i : A) {
      set.add(i);
    }
    int i = 1;
    while (set.contains(i)) {
      i++;
    }
    return i;
  }

  @Test
  public void test() {
    assertEquals(solution(new int[] {1, 2, 4}), 3);
  }
}
