import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution32 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);

    assertEquals(root, lowestCommonAncestor(root, root.left, root.right));
    assertEquals(root, lowestCommonAncestor(root, root.left.left, root.right.right));
  }
}
