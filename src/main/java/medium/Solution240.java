package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;

    int col = matrix[0].length - 1;
    int row = 0;

    while (col >= 0 && row <= matrix.length - 1) {
      if (target == matrix[row][col]) {
        return true;
      } else if (target < matrix[row][col]) {
        col--;
      } else if (target > matrix[row][col]) {
        row++;
      }
    }
    return false;
  }

  @Test
  public void test() {
    assertEquals(searchMatrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3), true);
  }
}
