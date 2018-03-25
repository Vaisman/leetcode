package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution65 {
  private List<TreeNode> ans;
  private Map<String, Integer> trees;
  private Map<Integer, Integer> count;
  int t;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    count = new HashMap();
    trees = new HashMap<>();
    ans = new ArrayList();
    t = 1;
    lookup(root);
    return ans;
  }

  public int lookup(TreeNode node) {
    if (node == null) {
      return 0;
    }

    String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
    int uid = trees.computeIfAbsent(serial, x -> t++);
    count.put(uid, count.getOrDefault(uid, 0) + 1);

    if (count.get(uid) == 2) {
      ans.add(node);
    }

    return uid;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(1);

    findDuplicateSubtrees(root);
  }
}
