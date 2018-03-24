package zero;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Solution81 {
  class MyStack {

    private Queue<Integer> main = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {}

    /** Push element x onto stack. */
    public void push(int x) {
      main.add(x);
      int size = main.size();
      for (int i = 0; i < size - 1; i++) {
        main.add(main.poll());
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return main.poll();
    }

    /** Get the top element. */
    public int top() {
      return main.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return main.isEmpty();
    }
  }

  @Test
  public void test() {
    MyStack s = new MyStack();
    s.push(1);
    s.push(2);
    s.push(3);

    assertEquals(s.pop(), 3);
    assertEquals(s.pop(), 2);
    assertEquals(s.pop(), 1);
  }
}
