package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution200 {
  public int numIslands(char[][] grid) {
    int count = 0;
    if (grid == null) return count;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          DFSMarking(grid, i, j);
          ++count;
        }
      }
    }
    return count;
  }

  private void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
  }

  @Test
  public void test() {
    char[][] arr =
        new char[][] {
          {'1', '1', '0', '0', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '1', '0', '0'},
          {'0', '0', '0', '1', '1'}
        };
    assertEquals(numIslands(arr), 3);
  }
}
