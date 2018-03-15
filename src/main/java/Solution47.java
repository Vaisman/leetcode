import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution47 {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    preorder(root, res);
    return res;
  }

  private void preorder(TreeNode root, List<Integer> res) {
    if (root == null) return;

    res.add(root.val);
    preorder(root.left, res);
    preorder(root.right, res);
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    preorderTraversal(root);
  }
}
