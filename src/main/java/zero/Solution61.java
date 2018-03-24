package zero;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution61 {
  public int rob(TreeNode root) {
    int res[] = search(root);
    return Math.max(res[0], res[1]);
  }

  private int[] search(TreeNode root) {
    int[] res = new int[2];
    if (root == null) return res;

    int[] left = search(root.left);
    int[] right = search(root.right);

    res[0] =
        Math.max(left[0], left[1])
            + Math.max(right[0], right[1]); // not rob current and max form parent (rob or unrob)
    res[1] = root.val + left[0] + right[0]; // rob current and not rob child
    return res;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(1);

    assertEquals(9, rob(root));
  }
}
