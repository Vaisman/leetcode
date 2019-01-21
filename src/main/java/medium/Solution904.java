package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution904 {
    public int totalFruit(int[] tree) {
        int fruitA = -1;
        int fruitB = -1;
        int countOfA = 0;
        int countOfAB = 0;
        int max = 0;

        for (int fruit : tree) {
            if (fruit == fruitA || fruit == fruitB) {
                countOfAB++;
            }
            else {
                countOfAB = countOfA + 1;
            }

            if (fruit == fruitA) {
                countOfA++;
            }
            else { // fruitB
                fruitB = fruitA;
                fruitA = fruit;
                countOfA = 1;
            }

            max = Math.max(max, countOfAB);
        }

        return max;
    }

    @Test
    public void test() {
        assertEquals(5 , totalFruit(new int[]{ 0, 1, 2, 2, 2, 1}));
    }
}
