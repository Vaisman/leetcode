import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution54 {
  public int divide(int dividend, int divisor) {

    int sign = 1;
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
      sign = -1;
    }

    long ldividend = Math.abs((long) dividend);
    long ldivisor = Math.abs((long) divisor);

    if (ldivisor == 0) {
      return Integer.MAX_VALUE;
    }

    if ((ldividend == 0) || (ldividend < ldivisor)) {
      return 0;
    }

    long lans = ldivide(ldividend, ldivisor);

    int ans;
    if (lans > Integer.MAX_VALUE) {
      ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      ans = (int) (sign * lans);
    }
    return ans;
  }

  private long ldivide(long dividend, long divisor) {
    if (dividend < divisor) {
      return 0;
    }

    long sum = divisor;
    long multiple = 1;
    while ((sum + sum) <= dividend) {
      sum += sum;
      multiple += multiple;
    }

    return multiple + ldivide(dividend - sum, divisor);
  }

  @Test
  public void test() {
    assertEquals(2, divide(4, 2));
  }
}
