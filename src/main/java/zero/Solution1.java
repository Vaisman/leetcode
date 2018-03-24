package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

public class Solution1 {

  public List<Integer> largestValuesBFS(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int queueSize = q.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = q.poll();
        max = Math.max(max, node.val);

        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
      result.add(max);
    }

    return result;
  }

  public List<Integer> largestValuesDFS(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res, 0);

    return res;
  }

  private void helper(TreeNode root, List<Integer> res, int d) {
    if (root == null) {
      return;
    }

    if (d == res.size()) {
      res.add(root.val);
    } else if (res.get(d) < root.val) {
      res.set(d, root.val);
    }

    helper(root.left, res, d + 1);
    helper(root.right, res, d + 1);
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(9);

    List<Integer> resultList = largestValuesBFS(root);
    List<Integer> resultListRec = largestValuesDFS(root);

    Integer[] result = new Integer[resultList.size()];

    Integer[] testData = new Integer[] {1, 3, 9};

    resultList.toArray(result);
    assertArrayEquals(testData, result);

    resultListRec.toArray(result);
    assertArrayEquals(testData, result);
  }
}
