import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution35 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        search(root);
        return max;
    }

    private int search(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(search(root.left), 0);
        int right = Math.max(search(root.right), 0);

        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(217);

        assertEquals(228, maxPathSum(root));
    }
}
