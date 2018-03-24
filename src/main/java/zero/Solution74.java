package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution74 {

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null) return 0;

    int max = 1;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, getMaxAround(i, j, grid));
        }
      }
    }
    return max;
  }

  private int getMaxAround(int i, int j, int[][] grid) {
    int max = 1;
    return max;
  }

  @Test
  public void test() {
    int[][] island = {
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    assertEquals(maxAreaOfIsland(island), 6);
  }
}
