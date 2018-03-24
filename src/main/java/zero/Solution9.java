package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution9 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) return res;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> pocket = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode n = q.poll();
        pocket.add(n.val);
        if (n.left != null) q.add(n.left);
        if (n.right != null) q.add(n.right);
      }
      res.add(pocket);
    }

    List<List<Integer>> finalRes = new ArrayList<>();
    for (int i = res.size() - 1; i >= 0; i--) {
      finalRes.add(res.get(i));
    }

    return finalRes;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(7);
  }
}
