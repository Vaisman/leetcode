import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution3 {

  int result = 0;

  private int postorder(TreeNode root) {
    if (root == null) return 0;

    int left = postorder(root.left);
    int right = postorder(root.right);
    result += Math.abs(left - right);

    return left + right + root.val;
  }

  public int findTilt(TreeNode root) {
    postorder(root);
    return result;
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    assertEquals(1, findTilt(root));
  }
}
