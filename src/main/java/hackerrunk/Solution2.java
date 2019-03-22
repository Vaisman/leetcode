package hackerrunk;

import java.util.*;

public class Solution2 {
  private class Pair {
    int[] person;
    int[] scooter;

    public Pair(int[] person, int[] scooter) {
      this.person = person;
      this.scooter = scooter;
    }

    public double dist() {
      int x = person[0] - scooter[0], y = person[1] - scooter[1];
      return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
  }

  public List<Pair> matchPeopleAndScooters(List<int[]> people, List<int[]> scooters) {
    final PriorityQueue<Pair> pq =
        new PriorityQueue<>((a, b) -> Double.compare(a.dist(), b.dist()));
    for (int[] p : people) {
      for (int[] s : scooters) {
        pq.offer(new Pair(p, s));
      }
    }
    Set<int[]> matched = new HashSet<>();
    List<Pair> matches = new ArrayList<>();
    while (matched.size() < people.size()) {
      Pair p = pq.poll();
      if (matched.contains(p.person)) {
        continue;
      }
      matches.add(p);
      matched.add(p.person);
    }
    return matches;
  }
}
