import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
Test task

You want to spend your next vacation in a foreign country. In the summer you are free for N consecutive days. You have consulted Travel Agency and learned that they are offering a trip to some interesting location in the country every day. For simplicity, each location is identified by a number from 0 to N - 1. Trips are described in a non-empty zero-indexed array A: for each K (0 = K < N), A[K] is the identifier of a location which is the destination of a trip offered on dayK. Travel Agency does not have to offer trips to all locations, and can offer more than one trip to some locations.

You want to go on a trip every day during your vacation. Moreover, you want to visit all locations offered by Travel Agency. You may visit the same location more than once, but you want to minimize duplicate visits. The goal is to find the shortest vacation (a range of consecutive days) that will allow you to visit all the locations offered by Travel Agency.

For example, consider array A such that:

A[0] = 7
A[1] = 3
A[2] = 7
A[3] = 3
A[4] = 1
A[5] = 3
A[6] = 4
A[7] = 1
Travel Agency offers trips to four different locations (identified by numbers 1, 3, 4 and 7). The shortest vacation starting on day 0 that allows you to visit all these locations ends on day 6 (thus is seven days long). However, a shorter vacation of five days (starting on day 2 and ending on day 6) also permits you to visit all locations. On every vacation shorter than five days, you will have to miss at least one location.

Write a function:

int solution(int A[], int N);

that, given a non-empty zero-indexed array A consisting of N integers, returns the length of the shortest vacation that allows you to visit all the offered locations.

For example, given array A shown above, the function should return 5, as explained above.

Assume that:

N is an integer within the range [1..100,000]; each element of array A is an integer within the range [0..N - 1].

Complexity:

expected worst-case time complexity is O(N); expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
*/

public class Solution18 {

  public int solution(int[] A) {
    Set<Integer> freq = new HashSet<>();

    for (int i : A) {
      freq.add(i);
    }

    for (int i = 0; i < A.length; i++) {
      freq.remove(A[i]);
      if (freq.size() == 0) {
        return i;
      }
    }

    return A.length - 1;
  }

  @Test
  public void test() {
    int[] n = new int[] {7, 3, 7, 3, 1, 3, 4, 1};
    assertEquals(6, solution(n));

    int[] n1 = new int[] {2, 1, 1, 3, 2, 1, 1, 3};
    assertEquals(6, solution(n));

    int[] n2 = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
    assertEquals(6, solution(n));
  }
}
