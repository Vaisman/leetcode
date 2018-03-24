package zero;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

public class Solution58 {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    return toBST(head, null);
  }

  public TreeNode toBST(ListNode head, ListNode tail) {
    ListNode slow = head;
    ListNode fast = head;

    if (head == tail) {
      return null;
    }

    // find middle
    while (fast != tail && fast.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }

    TreeNode middle = new TreeNode(slow.val);
    middle.left = toBST(head, slow);
    middle.right = toBST(slow.next, tail);
    return middle;
  }

  @Test
  public void test() {
    ListNode root = new ListNode(0);
    root.next = new ListNode(1);
    sortedListToBST(root);
  }
}
