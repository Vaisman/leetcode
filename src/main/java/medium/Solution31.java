package medium;

import org.junit.Test;

public class Solution31 {
  public void nextPermutation(int[] num) {
    if (num == null || num.length == 0) return;

    int n = num.length;
    if (n < 2) return;

    int index = n - 1;
    while (index > 0) {
      if (num[index - 1] < num[index]) break;
      index--;
    }

    if (index == 0) {
      reverseSort(num, 0, n - 1);
      return;
    } else {
      int val = num[index - 1];
      int j = n - 1;
      while (j >= index) {
        if (num[j] > val) break;
        j--;
      }

      swap(num, j, index - 1);
      reverseSort(num, index, n - 1);
      return;
    }
  }

  private void swap(int[] num, int i, int j) {
    int temp = 0;
    temp = num[i];
    num[i] = num[j];
    num[j] = temp;
  }

  private void reverseSort(int[] num, int start, int end) {
    if (start > end) return;
    for (int i = start; i <= (end + start) / 2; i++) {
      swap(num, i, start + end - i);
    }
  }

  @Test
  public void test() {
    nextPermutation(new int[] {1, 2, 3});
  }
}
