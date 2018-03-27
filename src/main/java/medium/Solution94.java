package medium;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Stack<TreeNode> stack = new Stack<>();
    pushAllLeft(root, stack);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(cur.val);
      pushAllLeft(cur.right, stack);
    }
    return res;
  }

  public void pushAllLeft(TreeNode node, Stack stack) {
    while (node != null) {
      stack.add(node);
      node = node.left;
    }
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    inorderTraversal(root);
  }
}
