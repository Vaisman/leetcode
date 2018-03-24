package zero;

import org.junit.Test;

public class Solution15 {

  private int getMaxHeight(TreeNode root) {
    if (root == null) return 0;
    return Math.max(getMaxHeight(root.right), getMaxHeight(root.left)) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    int lHeight = getMaxHeight(root.left);
    int rHeight = getMaxHeight(root.right);

    return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(lHeight - rHeight) <= 1);
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(2171);
    isBalanced(root);
  }
}
