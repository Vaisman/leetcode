package medium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class Node {
  int x;
  int y;
  int val;

  public Node(int x, int y, int val) {
    this.x = x;
    this.y = y;
    this.val = val;
  }
}

public class ATest2 {

  // runtime complexity O (n*m)
  // space complexity O (2*(n+m))

  //   Idea - DFS search
  // - validate input
  // - double for
  // - if found 9 start add in Queue
  // - while Queue not empty
  // - if invalid node data - continue
  // - if 0,0 - return result
  // - else add neighbours to Queue

  int minDistance(int numRows, int numColumns, List<List<Integer>> area) {
    if (area == null || area.isEmpty()) return -1;

    if (numRows == 0 || numColumns == 0) return -1;

    Queue<Node> q = new LinkedList<>();

    for (int i = 1; i < numRows; i++) {
      for (int j = 1; j < numColumns; j++) {
        if (area.get(i).get(j) == 9) {
          q.add(new Node(i, j, 0));
          break;
        }
      }
    }

    while (!q.isEmpty()) {
      Node node = q.poll();
      int i = node.x;
      int j = node.y;

      // out of maze
      if (i < 0 || j < 0 || i >= area.size() || j >= area.get(0).size()) {
        continue;
      }

      // visited or wall
      if (area.get(i).get(j) == 0) {
        continue;
      }

      if (i == 0 && j == 0) {
        return node.val;
      }

      area.get(i).set(j, 0);

      q.add(new Node(node.x + 1, node.y, node.val + 1));
      q.add(new Node(node.x - 1, node.y, node.val + 1));
      q.add(new Node(node.x, node.y + 1, node.val + 1));
      q.add(new Node(node.x, node.y - 1, node.val + 1));
    }

    return -1;
  }

  @Test
  public void test() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 0, 0));
    data.add(Arrays.asList(1, 0, 0));
    data.add(Arrays.asList(1, 9, 1));
    assertEquals(minDistance(3, 3, data), 3);
  }

  @Test
  public void test2() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 1, 1, 1));
    data.add(Arrays.asList(0, 1, 1, 1));
    data.add(Arrays.asList(0, 1, 0, 1));
    data.add(Arrays.asList(1, 1, 9, 1));
    data.add(Arrays.asList(0, 0, 1, 1));

    assertEquals(minDistance(5, 4, data), 5);
  }

  @Test
  public void test3() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 1, 1, 1));
    data.add(Arrays.asList(0, 0, 0, 1));
    data.add(Arrays.asList(1, 1, 0, 1));
    data.add(Arrays.asList(1, 9, 0, 1));
    data.add(Arrays.asList(1, 0, 0, 1));
    data.add(Arrays.asList(1, 1, 1, 1));

    assertEquals(minDistance(6, 4, data), 14);
  }

  @Test
  public void test4() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 0, 0));
    data.add(Arrays.asList(0, 0, 0));
    data.add(Arrays.asList(1, 9, 1));
    assertEquals(minDistance(3, 3, data), -1);
  }

  @Test
  public void test5() {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 1, 1, 1));
    data.add(Arrays.asList(0, 0, 0, 1));
    data.add(Arrays.asList(1, 1, 0, 1));
    data.add(Arrays.asList(1, 9, 0, 0));
    data.add(Arrays.asList(1, 0, 0, 1));
    data.add(Arrays.asList(1, 1, 1, 1));

    assertEquals(minDistance(6, 4, data), -1);
  }

  @Test
  public void test6() {
    List<List<Integer>> data = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      data.add(Arrays.asList(1, 1, 1, 1));
    }
    data.add(Arrays.asList(1, 9, 0, 0));
    assertEquals(minDistance(10001, 4, data), 10001);
  }
}
