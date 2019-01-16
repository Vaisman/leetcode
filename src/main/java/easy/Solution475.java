package easy;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                index = -(index + 1);
            }

            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    @Test
    public void test1() {
          assertEquals(findRadius(new int[] {1, 2, 3}, new int[] {2}), 1);
          assertEquals(findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4}), 1);
    }
}
