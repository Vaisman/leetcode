package zero;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution66 {
  private Map<Integer, Integer> sumToCount;
  private int maxCount;

  public int[] findFrequentTreeSum(TreeNode root) {
    maxCount = 0;
    sumToCount = new HashMap<>();
    dfs(root);

    List<Integer> res = new ArrayList<>();
    for (int key : sumToCount.keySet()) {
      if (sumToCount.get(key) == maxCount) {
        res.add(key);
      }
    }

    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      result[i] = res.get(i);
    }
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    int sum = root.val + left + right;
    int count = sumToCount.getOrDefault(sum, 0) + 1;
    sumToCount.put(sum, count);
    maxCount = Math.max(maxCount, count);
    return sum;
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(1);

    findFrequentTreeSum(root);
  }
}
