package careercup;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class Solution1 {

  List<Integer> sum = new ArrayList<>();

  public boolean cutTree(TreeNode root) {

    if (root == null) {
      return false;
    }

    int res = subTreeSum(root);
    if ((res % 2) == 0) {
      for (int i = 0; i < sum.size() - 1; i++) {
        if (sum.get(i) == (res / 2)) {
          return true;
        }
      }
    }

    return false;
  }

  public int subTreeSum(TreeNode node) {
    if (node == null) return 0;
    int result = node.val + subTreeSum(node.left) + subTreeSum(node.right);
    sum.add(result);
    return result;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;

    while(!stack.isEmpty() || p != null) {
      if(p != null) {
        stack.push(p);
        System.out.println("a "+ p.val);

        result.addFirst(p.val);  // Reverse the process of preorder
        p = p.right;             // Reverse the process of preorder
      } else {
        TreeNode node = stack.pop();
      //  System.out.println("b "+  node.val);

        p = node.left;           // Reverse the process of preorder
      }
    }

    return result;
  }


  @Test
  public void test() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    postorderTraversal(root);
    //assertTrue(cutTree(root));
  }
}
