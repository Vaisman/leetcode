package medium;

import common.ListNode;
import org.junit.Test;

import java.util.Random;

class Solution {

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
   *     contains at least one node.
   */
  public Solution(ListNode head) {
    this.head = head;
    this.random = new Random();
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode result = null;
    ListNode current = head;

    for (int i = 1; current.next != null; i++) {
      if (random.nextInt(i+1) == i) {
        result = current;
      }
      current = current.next;
    }
    return result.val;
  }

  private Random random = null;
  private ListNode head = null;
}

public class Solution382 {

  @Test
  public void test() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    Solution solution = new Solution(head);
    solution.getRandom();
  }
}
