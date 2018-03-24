package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution8 {
  public List<Double> averageOfLevels(TreeNode root) {

    List<Double> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      double sum = 0;
      int size = q.size();

      for (int i = 0; i < size; i++) {
        TreeNode n = q.poll();
        sum += n.val;
        if (n.left != null) q.add(n.left);
        if (n.right != null) q.add(n.right);
      }

      res.add(sum / size);
    }

    return res;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(10);
  }
}
