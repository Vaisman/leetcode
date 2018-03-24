package zero;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Solution64 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
        if (i == size - 1) {
          res.add(node.val);
        }
      }
    }

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

    rightSideView(root);
  }
}
