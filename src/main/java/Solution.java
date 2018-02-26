import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            int queueSize = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<queueSize; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(max);
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

        root.right.right = new TreeNode(9);

        List<Integer> resultList  = new Solution().largestValues(root);
        Integer[] result = new Integer[resultList.size()];
        resultList.toArray(result);
        assertArrayEquals(new Integer[]{1, 3, 9},result);
    }
}
