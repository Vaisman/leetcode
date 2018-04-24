package medium;

import common.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class Solution105 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length != inorder.length) {
      return null;
    }

    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  public TreeNode build(
      int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {

    if (preLow > preHigh || inLow > inHigh) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preLow]);

    int inorderRoot = inLow;
    for (int i = inLow; i <= inHigh; i++) {
      if (inorder[i] == root.val) {
        inorderRoot = i;
        break;
      }
    }

    int leftTreeLen = inorderRoot - inLow;
    root.left = build(preorder, preLow + 1, preLow + leftTreeLen, inorder, inLow, inorderRoot - 1);
    root.right =
        build(preorder, preLow + leftTreeLen + 1, preHigh, inorder, inorderRoot + 1, preHigh);
    return root;
  }

  public TreeNode buildTreeI(int[] preorder, int[] inorder) {

    if (preorder.length == 0) return null;

    Stack<TreeNode> s = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]), cur = root;

    for (int i = 1, j = 0; i < preorder.length; i++) {
      if (cur.val != inorder[j]) {
        cur.left = new TreeNode(preorder[i]);
        s.push(cur);
        cur = cur.left;
      } else {
        j++;

        while (!s.empty() && s.peek().val == inorder[j]) {
          cur = s.pop();
          j++;
        }

        cur = cur.right = new TreeNode(preorder[i]);
      }
    }

    return root;
  }

  @Test
  public void test() {
    buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
  }
}
