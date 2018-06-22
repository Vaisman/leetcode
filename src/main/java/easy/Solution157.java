package easy;

public class Solution157 {
  public int read(char[] buf, int n) {

    boolean eof = false;
    int total = 0;
    char[] tmp = new char[4];

    while (!eof && total < n) {
      int count = read4(tmp);

      // check if it's the end of the file
      eof = count < 4;

      // get the actual count
      count = Math.min(count, n - total);

      // copy from temp buffer to buf
      for (int i = 0; i < count; i++) buf[total++] = tmp[i];
    }

    return total;
  }

  public int read4(char[] buf) {
    return 4;
  }
}
