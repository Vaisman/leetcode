package easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

public class Solution760 {
  public int[] anagramMappings(int[] A, int[] B) {
    int[] res = new int[A.length];
    if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length)
      return res;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      map.put(B[i], i);
    }

    for (int i = 0; i < A.length; i++) {
      Integer x = map.get(A[i]);
      if (x != null) {
        res[i] = x;
      } else {
        return new int[] {};
      }
    }
    return res;
  }

  @Test
  public void test() {
    assertArrayEquals(
        new int[] {1, 4, 3, 2, 0},
        anagramMappings(new int[] {12, 28, 46, 32, 50}, new int[] {50, 12, 32, 46, 28}));
  }
}
