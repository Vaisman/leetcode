package medium;

public class Solution835 {
  public int largestOverlap(int[][] A, int[][] B) {
    int max = 0;
    int n = A.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, Math.max(getOverlap(A, B, i, j), getOverlap(B, A, i, j)));
      }
    }

    return max;
  }

  private int getOverlap(int[][] A, int[][] B, int rowOffset, int colOffset) {
    int sum = 0;
    int n = A.length;

    for (int i = rowOffset; i < n; i++) {
      for (int j = colOffset; j < n; j++) {
        sum += A[i][j] * B[i - rowOffset][j - colOffset];
      }
    }

    return sum;
  }
}
