package medium;

import common.TreeNode;

public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else root = root.right;
        }
        return res;
    }
}
