package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ATest4 {
  public int GCD(int num, int[] arr) {
    int result = arr[0];
    for (int i = 1; i < num; i++) result = gcd1(arr[i], result);

    return result;
  }

  int gcd1(int a, int b) {
    if (a == 0) return b;
    return gcd1(b % a, a);
  }

  @Test
  public void test1() {
    assertEquals(1, GCD(5, new int[] {2, 3, 4, 5, 6}));
    assertEquals(2, GCD(5, new int[] {2, 4, 6, 8, 10}));
  }
}
