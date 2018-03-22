import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution68 {
  public int countPrimeSetBits(int L, int R) {
    Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */));
    int count = 0;

    for (int i = L; i <= R; i++) {
      if (primes.contains(getBits(i))) {
        count++;
      }
    }

    return count;
  }

  private int getBits(int i) {
    int counter = 0;
    while (i > 0) {
      if ((i & 1) == 1) {
        counter++;
      }
      i >>= 1;
    }
    return counter;
  }

  @Test
  public void test() {
    assertEquals(4, countPrimeSetBits(6, 10));
    assertEquals(5, countPrimeSetBits(10, 15));
  }
}
