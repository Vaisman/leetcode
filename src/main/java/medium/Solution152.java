package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution152 {
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int iPos = 1;
    int iNeg = 1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = iPos;
        iPos = iNeg;
        iNeg = tmp;
      }

      iPos = Math.max(iPos * nums[i], nums[i]);
      iNeg = Math.min(iNeg * nums[i], nums[i]);

      max = Math.max(max, iPos);
    }

    return max;
  }

  public int maxProduct1(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int[] f = new int[A.length];
    int[] g = new int[A.length];
    f[0] = A[0];
    f[0] = A[0];
    g[0] = A[0];
    int res = A[0];

    for (int i = 1; i < A.length; i++) {
      f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
      g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
      res = Math.max(res, f[i]);
    }

    return res;
  }

  @Test
  public void test() {
    int[] arr = new int[] {2, 3, -2, 4};
    assertEquals(maxProduct1(arr), 6);
  }
}
