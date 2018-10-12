package medium;

public class Solution533 {
  public int findBlackPixel(char[][] picture, int N) {

    int[] row = new int[picture.length];
    int[] col = new int[picture[0].length];

    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[0].length; j++) {
        if (picture[i][j] == 'B') {
          row[i]++;
          col[j]++;
        }
      }
    }

    int count = 0;
    for (int j = 0; j < picture[0].length; j++) {
      if (col[j] != N) continue;
      boolean valid = true;
      String mark = "";
      for (int i = 0; i < picture.length; i++) {
        if (picture[i][j] == 'B') {
          if (row[i] != N || (mark.length() != 0 && !serialize(picture[i]).equals(mark))) {
            valid = false;
            break;
          }
          mark = serialize(picture[i]);
        }
      }
      if (valid) count += col[j];
    }

    return count;
  }

  public String serialize(char[] temp) {
    return new String(temp);
  }
}
