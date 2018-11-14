package easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution170 {
  public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;

    TwoSum() {
      sum = new HashSet<Integer>();
      num = new HashSet<Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
      if (num.contains(number)) {
        sum.add(number * 2);
      } else {
        Iterator<Integer> iter = num.iterator();
        while (iter.hasNext()) {
          sum.add(iter.next() + number);
        }
        num.add(number);
      }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
      return sum.contains(value);
    }
  }
}
