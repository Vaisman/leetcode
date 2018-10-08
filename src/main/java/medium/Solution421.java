package medium;

import java.util.HashSet;
import java.util.Set;

public class Solution421 {
  public int findMaximumXOR(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int mask = 0;
    int maxSum = 0;

    for (int i = 31; i > -1; i--) {
      mask = mask | (1 << i);
      set.clear();
      int possibleMax = maxSum | (1 << i);
      for (int n : nums) {
        int curt = n & mask;
        // if A ^ B = C, A = C ^ B;
        int diff = possibleMax ^ curt;
        if (set.contains(diff)) {
          // possibleMax = diff ^ curt
          maxSum = possibleMax;
          break;
        }
        set.add(curt);
      }
    }
    return maxSum;
  }

}
