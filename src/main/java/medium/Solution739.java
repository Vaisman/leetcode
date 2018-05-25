package medium;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class Solution739 {
  public int[] dailyTemperatures(int[] t) {
    if (t == null) return new int[] {};

    int[] res = new int[t.length];

    Stack<Integer> stack = new Stack<>();
    for (int i = t.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && t[i] >= t[stack.peek()]) stack.pop();

      res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

      stack.push(i);
    }

    return res;
  }

  @Test
  public void test() {
    assertArrayEquals(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}), new int[]{1, 1, 4, 2, 1, 1, 0, 0});
  }
}
