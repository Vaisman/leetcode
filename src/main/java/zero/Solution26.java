package zero;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

class MyTreeCalendar {
  private EventNode root;

  public MyTreeCalendar() {}

  public boolean book(int start, int end) {
    if (end < 0 || start < 0) return false;
    if (end < start) return false;

    if (root == null) {
      root = new EventNode(start, end);
      return true;
    }

    return treeBool(root, start, end);
  }

  public boolean treeBool(EventNode node, int start, int end) {
    boolean left_bool = false;
    boolean right_bool = false;

    if (end <= node.start) {
      if (node.left == null) {
        node.left = new EventNode(start, end);
        return true;
      }
      left_bool = treeBool(node.left, start, end);
    } else if (start >= node.end) {
      if (node.right == null) {
        node.right = new EventNode(start, end);
        return true;
      }
      right_bool = treeBool(node.right, start, end);
    }
    return left_bool || right_bool;
  }

  class EventNode {
    public int start;
    public int end;
    public EventNode left;
    public EventNode right;

    public EventNode(int s, int e) {
      start = s;
      end = e;
      left = null;
      right = null;
    }
  }
}

public class Solution26 {
  @Test
  public void test() {
    MyTreeCalendar calendar = new MyTreeCalendar();
    assertTrue(calendar.book(10, 20));
    assertFalse(calendar.book(-110, 20));
    assertFalse(calendar.book(20, 10));
    assertTrue(calendar.book(20, 30));
    assertFalse(calendar.book(10, 40));
    assertFalse(calendar.book(5, 15));
    assertFalse(calendar.book(15, 50));
  }
}
