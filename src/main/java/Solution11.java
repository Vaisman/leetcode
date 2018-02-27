import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution11 {

    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;

    private void rec(TreeNode root) {
        if (root == null) return;
        rec(root.left);
        if (prev != null)
            minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        rec(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        rec(root);
        return Math.abs(minDiff);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(217);
        assertEquals(3, getMinimumDifference(root));
    }
}
