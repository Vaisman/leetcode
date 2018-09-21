package medium;

import common.ListNode;
import org.junit.Test;

public class Solution92 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || m == n) return head;
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    dummy.next = head;
    for (int i = 0; i < m - 1; i++) pre = pre.next;
    ListNode start = pre.next;
    ListNode then = start.next;
    for (int i = 0; i < n - m; i++) {
      ListNode preNext = pre.next;
      ListNode thenNext = then.next;
      pre.next = then;
      then.next = preNext;
      start.next = thenNext;
      then = thenNext;
    }
    return dummy.next;
  }

  @Test
  public void test() {
    ListNode root = new ListNode(0);
    root.next = new ListNode(1);
    root.next.next = new ListNode(2);
    root.next.next.next = new ListNode(3);
    root.next.next.next.next = new ListNode(4);
    root.next.next.next.next.next = new ListNode(5);
    root.next.next.next.next.next.next = new ListNode(7);
    reverseBetween(root, 2, 5);
  }
}
