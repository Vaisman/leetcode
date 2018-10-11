package hard;

public class Solution312 {
    public int maxCoins(int[] nums) {
        return maxCoins(nums, 0, nums.length - 1);
    }

    public int maxCoins(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        int max = nums[start];
        for (int i = start; i <= end; i++) {
            int val = maxCoins(nums, start, i - 1) +
                    get(nums, i) * get(nums, start - 1) * get(nums, end + 1) +
                    maxCoins(nums, i + 1, end);

            max = Math.max(max, val);
        }

        return max;
    }

    public int get(int[] nums, int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        }
        return nums[i];
    }
}
