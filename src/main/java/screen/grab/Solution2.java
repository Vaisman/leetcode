package screen.grab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2 {
  public int solution(int[] A) {
    int count = 0;
    for (int i = 0; i <= A.length - 1; i++) {
      if (isIncreasing(A, 0, i - 1) && isIncreasing(A, i + 1, A.length - 1)) {
        count++;
      }
    }
    return count;
  }

  private boolean isIncreasing(int[] A, int left, int right) {
    if (left >= right) return true;

    for (int i = left; i < right; i++) {
      if (A[i] >= A[i + 1]) return false;
    }
    return true;
  }

  @Test
  public void test() {
    // assertEquals(solution( new int[]{3, 4, 5, 4}), 2);
    // assertEquals(solution( new int[]{4, 5, 2, 3, 4}), 0);
    // assertEquals(solution( new int[]{1, 2, 3, 3, 5, 6 ,7}), 7);
  }
}
