package medium;

// dfs
public class Solution207_1 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[][] graph = new int[numCourses][numCourses];
    boolean[] visited = new boolean[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      for (int j = 0; j < prerequisites[i].length; j++) {
        graph[i][j] = prerequisites[i][j];
      }
    }

    for (int k = 0; k < numCourses; k++) {
      if (!dfs(graph, visited, k)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int[][] graph, boolean[] visited, int course) {
    if (visited[course]) {
      return false;
    } else {
      visited[course] = true;
    }

    for (int i = 0; i < graph[course].length; i++) {
      if (!dfs(graph, visited, graph[course][i])) {
        return false;
      }
    }

    visited[course] = false;
    return true;
  }
}
