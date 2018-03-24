package zero;

import common.TreeNode;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution33 {

  private int search(TreeNode root, int sum) {
    if (root == null) return 0;
    sum = sum * 10 + root.val;
    if (root.left == null && root.right == null) return sum;
    return search(root.left, sum) + search(root.right, sum);
  }

  public int sumNumbers(TreeNode root) {
    int sum = 0;
    return search(root, sum);
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);

    assertEquals(595, sumNumbers(root));
  }
}
