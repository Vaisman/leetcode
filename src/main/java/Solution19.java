import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution19 {

  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null && root.right == null) return 1;

    if (root.left == null) return minDepth(root.right) + 1;

    if (root.right == null) return minDepth(root.left) + 1;

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    assertEquals(2, minDepth(root));
  }

  @Test
  public void testEmpty() {
    assertEquals(0, minDepth(null));
  }
}
