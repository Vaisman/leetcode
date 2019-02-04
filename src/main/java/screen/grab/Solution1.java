package screen.grab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1 {
  public String solution(int A, int B) {
    StringBuilder sb = new StringBuilder();
    traverse(A, B, sb);
    return sb.toString();
  }

  private void traverse(int A, int B, StringBuilder sb) {
      if ((A == 0) && (B == 0)) return;

      if (A > B) {
          if (sb.length() == 0 || sb.charAt(sb.length() - 1) == 'b') {
              if (A >= 2) {
                  A -= 2;
                  sb.append("aa");
              } else {
                  A -= 1;
                  sb.append("a");
              }
          }
          else if (sb.length() == 0 || sb.charAt(sb.length() - 1) == 'a') {
              if (B >= 2) {
                  B -= 2;
                  sb.append("bb");
              } else {
                  B -= 1;
                  sb.append("b");
              }
          }
      }
      else if (B >= A) {
          if (sb.length() == 0 || sb.charAt(sb.length() - 1) == 'a') {
              if (B >= 2) {
                  B -= 2;
                  sb.append("bb");
              } else {
                  B -= 1;
                  sb.append("b");
              }
          }
          else if (sb.length() == 0 || sb.charAt(sb.length() - 1) == 'b') {
              if (A >= 2) {
                  A -= 2;
                  sb.append("aa");
              } else {
                  A -= 1;
                  sb.append("a");
              }
          }
      }
      traverse(A, B, sb);
  }

  @Test
  public void test() {
     assertEquals(solution( 5, 3), "aabbaaba");
     assertEquals(solution( 3, 3), "bbaaba");
     assertEquals(solution( 1, 4), "bbabb");
  }
}
