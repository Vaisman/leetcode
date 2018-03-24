package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution59 {
  public boolean isValidSerialization(String preorder) {
    if (preorder == null || preorder.isEmpty()) return false;

    String[] nodes = preorder.split(",");
    int diff = 1;

    for (String node : nodes) {
      diff -= 1;

      if (diff < 0) {
        return false;
      }

      if (!node.equals("#")) {
        diff += 2;
      }
    }

    return diff == 0;
  }

  @Test
  public void test() {
    assertEquals(true, isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
  }
}
