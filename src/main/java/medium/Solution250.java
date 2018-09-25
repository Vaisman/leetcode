package medium;

import common.TreeNode;

public class Solution250 {
  int count;

  public int countUnivalSubtrees(TreeNode root) {
    count = 0;
    helper(root, Integer.MAX_VALUE);
    return count;
  }

  private boolean helper(TreeNode n, int v) {
    if (n == null) {
      return true;
    }

    boolean left = helper(n.left, n.val);
    boolean right = helper(n.right, n.val);

    if (left && right) {
      count++;
      return n.val == v;
    }

    return false;
  }
}
