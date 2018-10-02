package medium;

import common.TreeNode;

public class Solution701 {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    TreeNode cur = root;
    while (true) {
      if (cur.val <= val) {
        if (cur.right != null) cur = cur.right;
        else {
          cur.right = new TreeNode(val);
          break;
        }
      } else {
        if (cur.left != null) cur = cur.left;
        else {
          cur.left = new TreeNode(val);
          break;
        }
      }
    }
    return root;
  }

  public TreeNode insertIntoBST1(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);

    if (val < root.val) {
      root.left = insertIntoBST1(root.left, val);
    } else {
      root.right = insertIntoBST1(root.right, val);
    }
    return root;
  }
}
