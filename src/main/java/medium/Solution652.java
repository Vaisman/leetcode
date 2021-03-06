package medium;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution652 {
  private Map<String, Integer> count;
  private List<TreeNode> ans;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    count = new HashMap();
    ans = new ArrayList();
    collect(root);
    return ans;
  }

  private String collect(TreeNode node) {
    if (node == null) return "#";

    String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
    System.out.println("node ="+  node.val);
    System.out.println(serial);
    count.put(serial, count.getOrDefault(serial, 0) + 1);

    if (count.get(serial) == 2) {
      ans.add(node);
    }

    return serial;
  }

  @Test
  public void test() {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      root.left.left = new TreeNode(4);

      root.right.left = new TreeNode(2);
      root.right.right = new TreeNode(4);
      findDuplicateSubtrees(root);
  }
}
