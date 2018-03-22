import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution67 {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }

    int maxLength = 0;

    for (int i : set) {
      if (!set.contains(i - 1)) {
        int currentNum = i;
        int currentStreak = 1;

        while (set.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        maxLength = Math.max(maxLength, currentStreak);
      }
    }

    return maxLength;
  }

  @Test
  public void test() {
    assertEquals(2, longestConsecutive(new int[] {4, 1, 2}));
    assertEquals(4, longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }
}
