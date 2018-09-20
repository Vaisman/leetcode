package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }


    @Test
    public void test() {
        assertEquals(findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}), 9);
    }
}
