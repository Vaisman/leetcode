import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution56 {

  private TreeNode prev = null;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.right);
    flatten(root.left);

    root.right = prev;
    root.left = null;

    prev = root;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(9);
    flatten(root);
  }
}
