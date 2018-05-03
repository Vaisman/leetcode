package medium;

import common.ListNode;
import org.junit.Test;

public class Solution148 {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // step 3. merge l1 and l2
    return merge(l1, l2);
  }

  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null) p.next = l1;
    if (l2 != null) p.next = l2;

    return l.next;
  }

  @Test
  public void test() {
    ListNode head = new ListNode(0);
    head.next = new ListNode(3);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(4);

    sortList(head);
  }
}

/*
    MergeSort(arr[], l,  r)
    If r > l
        1. Find the middle point to divide the array into two halves:
        middle m = (l+r)/2
        2. Call mergeSort for first half:
        Call mergeSort(arr, l, m)
        3. Call mergeSort for second half:
        Call mergeSort(arr, m+1, r)
        4. Merge the two halves sorted in step 2 and 3:
        Call merge(arr, l, m, r)
*/
