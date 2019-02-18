package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] cups = new double[query_row + 1];
        cups[0] = poured;

        for (int i = 0; i < query_row; i++) {

            System.out.println("row=" + i);

            for (int j = i; j >= 0; j--) {
                double overflow = Math.max(0, cups[j] - 1);

                System.out.println("i=" + i + " j="+j + " overflow=" + overflow);

                if (j + 1 <= query_row) {
                    cups[j + 1] += overflow / 2;
                }

                cups[j] = overflow / 2;
            }
        }

        return cups[query_glass] >= 1 ? 1 : cups[query_glass];
    }

    @Test
    public void test() {
        //assertEquals(champagneTower(1, 1, 1), 0, 0.01);
        assertEquals(champagneTower(4, 2, 2), 0.25, 0.01);
    }
}
