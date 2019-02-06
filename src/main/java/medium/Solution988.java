package medium;

import common.TreeNode;

public class Solution988 {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root);
    }

    public String dfs(TreeNode node) {
        if (null == node) {
            return null;
        } else {

            char ch = (char) ('a' + node.val);
            String left = dfs(node.left);
            String right = dfs(node.right);

            if (left == null && right == null) { // leaf
                return "" + ch;
            } else if (left == null || right == null) {
                return left != null ? (left + ch) : (right + ch);
            } else { // both are not null
                if (left.compareTo(right) < 0) {
                    return left + ch;
                } else {
                    return right + ch;
                }
            }
        }
    }
}
