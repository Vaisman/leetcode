package medium;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    level(result, root);
    return result;
  }

  private int level(List<List<Integer>> result, TreeNode node) {
    if (node == null) {
      return -1;
    }

    int leftLevel = level(result, node.left);
    int rightLevel = level(result, node.right);
    int levels = Math.max(leftLevel, rightLevel) + 1;

    if (result.size() == levels) {
      List<Integer> li = new ArrayList<>();
      li.add(node.val);
      result.add(li);
    } else {
      result.get(levels).add(node.val);
    }
    System.out.println("Level=" + levels + " Node =" + node.val);
    return levels;
  }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        findLeaves(root);
    }
}
