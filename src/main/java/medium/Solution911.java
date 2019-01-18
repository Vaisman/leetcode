package medium;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class Solution911 {

    TreeMap<Integer, Integer> timeWinnerMap = new TreeMap<>();

    public Solution911(int[] persons, int[] times) {
        Map<Integer, Integer> voteCount = new HashMap<>();

        int maxVote = Integer.MIN_VALUE;
        int winner = -1;

        for(int i = 0; i < persons.length; i++) {
            voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);

            if(voteCount.get(persons[i]) >= maxVote) {
                maxVote = voteCount.get(persons[i]);
                winner = persons[i];
            }

            timeWinnerMap.put(times[i], winner);
        }
    }

    public int q(int t) {
        return timeWinnerMap.get(timeWinnerMap.floorKey(t));
    }

    @Test
    public void test() {
        Solution911 s = new Solution911(new int[]{}, new int[]{});
        assertEquals(s.q(1), 1);
    }
}
