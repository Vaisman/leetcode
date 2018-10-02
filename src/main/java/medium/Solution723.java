package medium;

public class Solution723 {
  public int[][] candyCrush(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return new int[][] {};
    }

    boolean changed = true;
    int len = board.length, wid = board[0].length;

    while (changed) {
      changed = false;

      for (int i = 0; i < len; i++) {
        for (int j = 0; j < wid; j++) {
          if (board[i][j] == 0) {
            continue;
          }
          int value = Math.abs(board[i][j]);
          if (i < len - 2
              && value == Math.abs(board[i + 1][j])
              && value == Math.abs(board[i + 2][j])) {
            changed = true;
            board[i][j] = -value;
            board[i + 1][j] = -value;
            board[i + 2][j] = -value;
          }
          if (j < wid - 2
              && value == Math.abs(board[i][j + 1])
              && value == Math.abs(board[i][j + 2])) {
            changed = true;
            board[i][j] = -value;
            board[i][j + 1] = -value;
            board[i][j + 2] = -value;
          }
        }
      }

      // window
      if (changed) {
        for (int j = 0; j < wid; j++) {
          int btm = len - 1;
          for (int i = len - 1; i >= 0; i--) {
            if (board[i][j] > 0) {
              board[btm--][j] = board[i][j];
            }
          }
          for (int i = btm; i >= 0; i--) {
            board[i][j] = 0;
          }
        }
      }
    }
    return board;
  }
}
