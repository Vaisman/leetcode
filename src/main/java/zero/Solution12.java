package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution12 {

  int min = Integer.MAX_VALUE;

  private void rec(TreeNode n, TreeNode prev) {
    if (n == null) return;

    if (prev != null) min = Math.min(min, n.val - prev.val);

    rec(n.left, n);
    rec(n.right, n);
  }

  public int minDiffInBST(TreeNode root) {
    if (root == null) return 0;

    rec(root, null);
    return min;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    assertEquals(1, minDiffInBST(root));
  }
}
