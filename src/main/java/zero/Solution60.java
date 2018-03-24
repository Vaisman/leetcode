package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class Solution60 {
  public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
      pushAll(root);
    }

    public boolean hasNext() {
      return !stack.empty();
    }

    public int next() {
      TreeNode node = stack.pop();
      pushAll(node.right);
      return node.val;
    }

    private void pushAll(TreeNode node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(9);
    root.right.right = new TreeNode(8);

    int[] res = {5, 2, 3, 1, 7, 8};
    BSTIterator iterator = new BSTIterator(root);
    int i = 0;
    while (iterator.hasNext()) {
      assertEquals(res[i++], iterator.next());
    }
  }
}
