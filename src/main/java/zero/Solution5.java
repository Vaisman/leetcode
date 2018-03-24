package zero;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class Solution5 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int counter = 0;
    for (int j = 0; counter < g.length && j < s.length; j++) {
      if (g[counter] <= s[j]) counter++;
    }
    return counter;
  }

  @Test
  public void test() {
    assertEquals(1, findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
    assertEquals(2, findContentChildren(new int[] {1, 2, 3}, new int[] {1, 2}));
    assertEquals(2, findContentChildren(new int[] {1, 2, 3}, new int[] {2, 2}));
  }
}
