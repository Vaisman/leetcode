package medium;

import common.TreeNode;

public class Solution998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int v) {
        if (root == null) {
            return new TreeNode(v);
        }

        if (root.val < v) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, v);
        return root;
    }
}
