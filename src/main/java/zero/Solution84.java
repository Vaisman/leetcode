package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution84 {

    public int findNthDigit(int n) {
        int start = 1;
        int len = 1;
        long count = 9;

        while(len * count < n) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        int num = start + (n - 1) / len;

        return Integer.toString(num).charAt((n - 1) % len) - '0';
    }

  @Test
  public void test() {
    assertEquals(findNthDigit(11), 0);
  }
}
