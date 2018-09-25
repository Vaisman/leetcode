package medium;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution776 {
  public TreeNode[] splitBST(TreeNode root, int V) {
    if (root == null) return new TreeNode[] {null, null};

    TreeNode[] splitted;
    if (root.val <= V) {
      splitted = splitBST(root.right, V);
      root.right = splitted[0];
      splitted[0] = root;
    } else {
      splitted = splitBST(root.left, V);
      root.left = splitted[1];
      splitted[1] = root;
    }

    return splitted;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    TreeNode[] splitted = splitBST(root, 2);
    int a = 1;
  }
}
