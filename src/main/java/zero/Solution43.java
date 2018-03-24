package zero;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;

public class Solution43 {
  public int[] findErrorNums(int[] nums) {
    int[] res = {0, 0};
    if (nums == null || nums.length == 0) {
      return res;
    }

    Set<Integer> s = new HashSet<>();

    for (int n : nums) {
      if (s.contains(n)) {
        res[0] = n;
      } else {
        s.add(n);
      }
    }

    for (int i = 1; i <= nums.length; i++) {
      if (!s.contains(i)) {
        res[1] = i;
      }
    }

    return res;
  }

  @Test
  public void test() {
    assertArrayEquals(new int[] {2, 4}, findErrorNums(new int[] {1, 2, 3, 2}));
  }
}
