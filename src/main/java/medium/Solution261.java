package medium;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution261 {
  boolean validTree(int n, int[][] edges) {
    // initialize n isolated islands
    int[] nums = new int[n];
    Arrays.fill(nums, -1);

    // perform union find
    for (int i = 0; i < edges.length; i++) {
      int x = find(nums, edges[i][0]);
      int y = find(nums, edges[i][1]);
      System.out.println( x + " " + y);
      System.out.println(Arrays.toString(nums ));

        // if two vertices happen to be in the same set
      // then there's a cycle
      if (x == y) return false;

      // union
      nums[x] = y;
    }

    return edges.length == n - 1;
  }

  int find(int nums[], int i) {
    if (nums[i] == -1) return i;
    return find(nums, nums[i]);
  }

  @Test
  public void test() {
    int[][] graph = new int[4][2];
    graph[0][0] = 0;
    graph[0][1] = 1;

    graph[1][0] = 0;
    graph[1][1] = 2;

    graph[2][0] = 0;
    graph[2][1] = 3;

    graph[3][0] = 1;
    graph[3][1] = 4;

    validTree(5, graph);
  }
}
