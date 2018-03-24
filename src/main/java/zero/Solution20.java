package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution20 {

  int res;

  public int longestUnivaluePath(TreeNode root) {
    res = 0;
    arrowLength(root);
    return res;
  }

  public int arrowLength(TreeNode node) {
    if (node == null) return 0;

    int left = arrowLength(node.left);
    int right = arrowLength(node.right);

    int arrowLeft = 0;
    int arrowRight = 0;

    if (node.left != null && node.left.val == node.val) {
      arrowLeft += left + 1;
    }

    if (node.right != null && node.right.val == node.val) {
      arrowRight += right + 1;
    }

    res = Math.max(res, arrowLeft + arrowRight);

    return Math.max(arrowLeft, arrowRight);
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    assertEquals(1, longestUnivaluePath(root));
  }
}
