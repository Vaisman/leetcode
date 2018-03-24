package zero;

import common.TreeNode;
import org.junit.Test;

public class Solution14 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val > q.val && root.val > p.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (root.val < q.val && root.val < p.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;
    }
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    lowestCommonAncestor(root, root.right, root.left.right);
  }
}
