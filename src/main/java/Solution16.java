import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution16 {

    int count = 0;
    int max = Integer.MIN_VALUE;
    TreeNode prev = null;

    private void traverse(TreeNode root, List<Integer> res) {
        if (root == null)
               return;

        traverse(root.left, res);

        if (prev != null) {
            if (root.val == prev.val)
                count++;
            else
                count = 1;

            if (count > max) {
                max = count;
                res.clear();
                res.add(root.val);
            } else if (count == max) {
                res.add(root.val);
            }
        }

        prev = root;
        traverse(root.right, res);
    }

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};

        List<Integer> res = new ArrayList<>();

        traverse(root, res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) result[i] = res.get(i);
        return result;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(2171);
        findMode(root);
    }
}
