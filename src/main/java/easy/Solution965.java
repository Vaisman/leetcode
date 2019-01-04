package easy;

import common.TreeNode;

public class Solution965 {
    private boolean dfs(TreeNode root, int value) {
        if (root == null) return true;
        return root.val == value && dfs(root.left, value) && dfs(root.right, value);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root, root.val);
    }
}
