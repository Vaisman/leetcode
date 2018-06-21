package easy;

import common.TreeNode;

public class Solution270 {
  public int closestValue(TreeNode root, double target) {
    int curr = root.val;
    TreeNode kid = target < curr ? root.left : root.right;
    if (kid == null) return curr;
    int closest = closestValue(kid, target);
    return Math.abs(curr - target) < Math.abs(closest - target) ? curr : closest;
  }
}
