package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution37 {

  private int minLevel = 0;
  private int maxLevel = 0;
  private Map<Integer, ArrayList<Integer>> mem = new HashMap<>();

  private void traverse(TreeNode root, int level) {
    if (root == null) return;

    if (level < minLevel) minLevel = level;
    if (level > maxLevel) maxLevel = level;

    ArrayList<Integer> list = mem.getOrDefault(level, new ArrayList<>());
    list.add(root.val);
    mem.put(level, list);

    traverse(root.left, level - 1);
    traverse(root.right, level + 1);
  }

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    traverse(root, 0);

    for (int i = minLevel; i <= maxLevel; i++) {
      if (mem.containsKey(i)) {
        result.add(mem.get(i));
        System.out.println(i + "  " + mem.get(i).toString());
      }
    }

    return result;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);
    verticalOrder(root);
  }
}
