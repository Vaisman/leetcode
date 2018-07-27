package medium;

import common.TreeNode;

public class Solution872 {
  private void dfs(TreeNode root, StringBuilder sb) {
    if (root == null) return;

    if (root.left == null && root.right == null) sb.append(root.val);

    dfs(root.left, sb);
    dfs(root.right, sb);
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    dfs(root1, sb1);
    dfs(root2, sb2);
    return sb1.toString().equals(sb2.toString());
  }
}
