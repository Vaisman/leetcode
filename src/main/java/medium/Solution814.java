package medium;

import common.TreeNode;
import org.junit.Test;

public class Solution814 {

  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    return (root.val == 1 || root.left != null || root.right != null) ? root : null;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);

    pruneTree(root);
  }
}
