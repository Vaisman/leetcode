package medium;

import common.ListNode;

public class Solution369 {
  public ListNode plusOne(ListNode head) {
    if (DFS(head) == 0) {
      return head;
    } else {
      ListNode newHead = new ListNode(1);
      newHead.next = head;
      return newHead;
    }
  }

  public int DFS(ListNode head) {
    if (head == null) return 1;

    int carry = DFS(head.next);

    if (carry == 0) return 0;

    int val = head.val + 1;
    head.val = val % 10;
    return val / 10;
  }
}
