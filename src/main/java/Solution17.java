import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution17 {

  private boolean searchBST(TreeNode root, int sum) {
    if (root == null) return false;

    if (root.left == null && root.right == null)
      if ((sum - root.val) == 0) return true;
      else return false;

    return searchBST(root.left, sum - root.val) || searchBST(root.right, sum - root.val);
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    return searchBST(root, sum);
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    assertFalse(hasPathSum(root, 1));
  }
}
