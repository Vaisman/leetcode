package zero;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution10 {

  private void rec(TreeNode t, StringBuilder sb) {
    if (t != null) {
      sb.append(t.val);
      if (t.left != null || t.right != null) {
        sb.append("(");
        rec(t.left, sb);
        sb.append(")");

        if (t.right != null) {
          sb.append("(");
          rec(t.right, sb);
          sb.append(")");
        }
      }
    }
  }

  public String tree2str(TreeNode t) {
    StringBuilder sb = new StringBuilder();
    rec(t, sb);
    return sb.toString();
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(27);
    assertEquals("1(2(5)(3))(3(27))", tree2str(root));
  }
}
