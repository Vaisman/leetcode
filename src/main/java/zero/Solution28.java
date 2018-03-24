package zero;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class MyTreeCalendarTwo {
  Node root;

  class Node {
    Node left;
    Node right;
    int start;
    int end;
    int count = 1;

    Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public MyTreeCalendarTwo() {}

  public boolean book(int start, int end) {
    if (end < 0 || start < 0) return false;
    if (end < start) return false;

    if (search(root, start, end)) {
      return false;
    }

    root = add(root, start, end);
    return true;
  }

  private boolean search(Node cur, int start, int end) {

    if (cur == null) {
      return false;
    }

    if (cur.count == 2
        && ((start < cur.end && start >= cur.start)
            || (end > cur.start && end <= cur.end)
            || (start <= cur.start && end >= cur.end))) {
      return true;
    }

    if (start >= cur.start && end <= cur.end) {
      return false;
    }

    if (start >= cur.end) {
      return search(cur.right, start, end);
    }

    if (end <= cur.start) {
      return search(cur.left, start, end);
    }

    return search(cur.left, start, cur.start) || search(cur.right, cur.end, end);
  }

  private Node add(Node cur, int start, int end) {

    if (start >= end) {
      return cur;
    }
    if (cur == null) {
      return new Node(start, end);
    }

    if (start >= cur.end) {
      cur.right = add(cur.right, start, end);
      return cur;
    }
    if (end <= cur.start) {
      cur.left = add(cur.left, start, end);
      return cur;
    }

    cur.count++;
    cur.left = add(cur.left, Math.min(cur.start, start), Math.max(cur.start, start));
    cur.right = add(cur.right, Math.min(cur.end, end), Math.max(cur.end, end));

    cur.start = Math.max(cur.start, start);
    cur.end = Math.min(cur.end, end);
    return cur;
  }
}

public class Solution28 {
  @Test
  public void test() {
    MyTreeCalendarTwo calendar = new MyTreeCalendarTwo();
    assertFalse(calendar.book(-110, 20));
    assertTrue(calendar.book(10, 20));
    assertTrue(calendar.book(50, 60));
    assertTrue(calendar.book(10, 40));
    assertFalse(calendar.book(5, 15));
    assertTrue(calendar.book(5, 10));
    assertTrue(calendar.book(25, 55));
  }
}
