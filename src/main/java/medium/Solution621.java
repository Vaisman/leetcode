package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution621 {
  public int leastInterval(char[] tasks, int n) {
    int len = tasks.length;
    int[] count = new int[26];
    int max = 0, maxNum = 0;

    for (char c : tasks) {
      count[c - 'A']++;

      if (count[c - 'A'] > max) {
        max = count[c - 'A'];
        maxNum = 1;
      } else if (count[c - 'A'] == max) {
        maxNum++;
      }

    }

    return Math.max(len, (max - 1) * (n + 1) + maxNum);
  }

  @Test
  public void test() {
    assertEquals(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2), 8);
  }
}
