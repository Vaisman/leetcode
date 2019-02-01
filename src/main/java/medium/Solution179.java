package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }

        Arrays.sort(strs, (i, j) -> {
            String s1 = i+j;
            String s2 = j+i;
            return s1.compareTo(s2);
        });

        if (strs[strs.length-1].charAt(0) == '0')
            return "0";

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.insert(0, str);
        }

        return res.toString();
    }
}
