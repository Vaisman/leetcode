package easy;

import common.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode fake = new ListNode(-1);
        ListNode head = fake;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                fake.next = l1;
                l1 = l1.next;
            } else {
                fake.next = l2;
                l2 = l2.next;
            }
            fake = fake.next;
        }

        return head.next;
    }

}
