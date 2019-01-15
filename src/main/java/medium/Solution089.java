package medium;

import common.TreeNode;

// LargestBSTInBinaryTree
public class Solution089 {
    MinMax largest(TreeNode root) {
        if (root == null)
            return new MinMax();

        MinMax left = largest(root.left);
        MinMax right = largest(root.right);

        if (!left.isBST || !right.isBST || root.val < left.max ||
                root.val > right.min)
            return new MinMax();

        MinMax m = new MinMax();
        m.size = left.size + 1 + right.size;
        m.min = root.left == null ? root.val : left.min;
        m.max = root.right == null ? root.val : right.max;
        return m;
    }

    class MinMax {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        int size=0;
        boolean isBST=true;
    }
}
