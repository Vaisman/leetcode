package zero;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

class MyQueue {

  private Stack<Integer> stack = new Stack<>();

  /** Initialize your data structure here. */
  public MyQueue() {}

  /** Push element x to the back of queue. */
  public void push(int x) {
    Stack<Integer> pocket = new Stack<>();
    while (!stack.isEmpty()) {
      pocket.push(stack.pop());
    }
    stack.push(x);
    while (!pocket.isEmpty()) {
      stack.push(pocket.pop());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return stack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return stack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.empty();
  }
}

public class Solution6 {
  @Test
  public void test() {
    MyQueue obj = new MyQueue();
    obj.push(1);
    assertEquals(1, obj.peek());
    assertEquals(1, obj.pop());
    assertEquals(true, obj.empty());
  }
}
