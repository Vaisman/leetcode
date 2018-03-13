import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Solution30 {

  int solution1(int M, int[] A) {

    int N = A.length;

    int[] count = new int[M + 1];

    for (int i = 0; i <= M; i++) count[i] = 0;

    int maxOccurence = 1;
    int index = 0;

    for (int i = 0; i < N; i++) {
      if (count[A[i]] > 0) {
        int tmp = count[A[i]];
        if (tmp > maxOccurence) {
          maxOccurence = tmp;
          index = i;
        }
        count[A[i]] = tmp + 1;
      } else {
        count[A[i]] = 1;
      }
    }

    return A[index];
  }

  public int solution2(int[] A) {
    Arrays.sort(A);

    int prevVal = A[1];
    int minDistance = Math.abs(A[1] - A[0]);

    for (int i = 2; i < A.length; i++) {
      int curVal = A[i];

      int dist = Math.abs(curVal - prevVal);

      if (dist == 0) {
        return 0;
      }

      if (dist < minDistance) {
        minDistance = dist;
      }

      prevVal = curVal;
    }

    return minDistance;
  }

  public int solution3(int[] A) {
    int maxSumP = Integer.MIN_VALUE;
    int maxSumQ = Integer.MIN_VALUE;

    for (int i = 0; i < A.length; i++) {

      int currSumP = i + A[i];
      int currSumQ = A[i] - i;

      if (maxSumP < currSumP) {
        maxSumP = currSumP;
      }

      if (maxSumQ < currSumQ) {
        maxSumQ = currSumQ;
      }
    }
    return maxSumP + maxSumQ;
  }

  public int solution4(int[] A) {
    long sum = 0;
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    int min = Integer.MAX_VALUE;
    int minIndex = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] > max) {
        max = A[i];
        maxIndex = i;
      }
      if (A[i] < min) {
        min = A[i];
        minIndex = i;
      }
      sum = sum + A[i];
    }

    long avg = sum / A.length;
    return (Math.abs(avg - min) > Math.abs(avg - max)) ? minIndex : maxIndex;
  }

  @Test
  public void test1() {
    assertEquals(3, solution1(3, new int[] {1, 2, 3, 3, 1, 3, 1}));
    assertEquals(1, solution1(1, new int[] {1}));
    assertEquals(1, solution1(1, new int[] {1, 1, 1, 1}));
    assertEquals(2, solution1(200, new int[] {1, 2, 1, 2, 2}));
  }

  @Test
  public void test2() {
    assertEquals(0, solution2(new int[] {7, 21, 3, 42, 3, 7}));
    assertEquals(1, solution2(new int[] {1, 2}));
    assertEquals(2, solution2(new int[] {8, 24, 3, 20, 1, 17}));
  }

  @Test
  public void test3() {
    assertEquals(6, solution3(new int[] {1, 3, -3}));
    assertEquals(14, solution3(new int[] {-8, 4, 0, 5, -3, 6}));
    assertEquals(2, solution3(new int[] {1}));
  }

  @Test
  public void test4() {
    assertEquals(3, solution4(new int[] {9, 4, -3, -10}));
  }
}
