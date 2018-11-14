package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution153 {
  public int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }
    if (num.length == 1) {
      return num[0];
    }
    int start = 0, end = num.length - 1;
    while (start < end) {
        int mid = (start + end) / 2;
        System.out.println("mid= " + mid );

        if (mid > 0 && num[mid] < num[mid - 1]) {
            return num[mid];
        }

        System.out.println("start= " + start + " mid= " + mid  + " end= " + end);

        if (num[start] <= num[mid] && num[mid] > num[end]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return num[start];
  }

    @Test
    public void test() {
       assertEquals(0 ,findMin(new int[] {4,5,6,7,0,1,2}));
    }
}
