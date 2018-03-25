package easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution575 {
  public int distributeCandies(int[] candies) {
    Set<Integer> kinds = new HashSet<>();
    for (int candy : candies) kinds.add(candy);
    return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
  }

  @Test
  public void test1() {
    assertEquals(3, distributeCandies(new int[] {1, 1, 2, 2, 3, 3}));
    assertEquals(2, distributeCandies(new int[] {1, 1, 2, 3}));
  }
}
