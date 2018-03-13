import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution31 {
  public boolean canWinNim(int n) {
    return n % 4 != 0;
  }

  @Test
  public void test1() {
    assertEquals(false, canWinNim(0));
    assertEquals(true, canWinNim(1));
  }
}
