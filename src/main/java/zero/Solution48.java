package zero;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution48 {

  public class Codec {

    private static final String SPLITER = ",";
    private static final String NULL = "N";

    public String serialize(TreeNode root) {
      StringBuilder res = new StringBuilder();
      traverse(root, res);
      return res.toString();
    }

    private void traverse(TreeNode root, StringBuilder res) {
      if (root == null) {
        res.append(NULL + SPLITER);
      } else {
        res.append(root.val + SPLITER);
        traverse(root.left, res);
        traverse(root.right, res);
      }
    }

    public TreeNode deserialize(String data) {
      Queue<String> queue = new LinkedList<>();
      queue.addAll(Arrays.asList(data.split(SPLITER)));
      return traverse(queue);
    }

    public TreeNode traverse(Queue<String> queue) {
      String cur = queue.poll();
      if (cur.equals(NULL)) {
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(cur));
      root.left = traverse(queue);
      root.right = traverse(queue);
      return root;
    }
  }

  @Test
  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(217);

    Codec codec = new Codec();
    codec.deserialize(codec.serialize(root));
  }
}
