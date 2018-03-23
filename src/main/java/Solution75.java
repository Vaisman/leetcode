import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution75 {
  public int rotatedDigits(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (isValid(i)) count++;
    }
    return count;
  }

  public boolean isValid(int N) {
    while (N > 0) {
      int i = N % 10;
      if (i == 3 || i == 4 || i == 7 || i == 1 || i == 8) return false;
      N = N / 10;
    }
    return true;
  }

  @Test
  public void test() {
    assertEquals(rotatedDigits(10), 4);
  }
}
