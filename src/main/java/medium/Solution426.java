package medium;

import common.ListDoubleNode;

public class Solution426 {
    ListDoubleNode prev = null;

    public ListDoubleNode treeToDoublyList(ListDoubleNode root) {
        if (root == null) return null;

        ListDoubleNode dummy = new ListDoubleNode();
        prev = dummy;

        helper(root);

        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(ListDoubleNode cur) {
        if (cur == null) return;
        helper(cur.left);

        prev.right = cur;
        cur.left = prev;
        prev = cur;

        helper(cur.right);
    }
}
