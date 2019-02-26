package medium;

public class Solution209 {
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0;
        int j = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
