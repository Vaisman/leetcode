package easy;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution256 {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curR = Math.min(lastG, lastB) + costs[i][0];
            int curG = Math.min(lastR, lastB) + costs[i][1];
            int curB = Math.min(lastR, lastG) + costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(Math.min(lastR, lastG), lastB);
    }

    @Test
    public void test1() {
        assertEquals(minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}), 10);
    }
}
