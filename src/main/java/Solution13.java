import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {

  private void search(TreeNode n, String path, List<String> res) {
    if (n.left == null && n.right == null) res.add(path + n.val);

    if (n.left != null) search(n.left, path + n.val + "->", res);

    if (n.right != null) search(n.right, path + n.val + "->", res);
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();

    if (root == null) return res;

    search(root, "", res);

    return res;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    binaryTreePaths(root);
  }
}
