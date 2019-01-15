package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() < 3)
            return res;

        int left = 0;
        int right = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                right++;
            }
            else {
                if (right - left >= 2) {
                    List<Integer> curr = new ArrayList();
                    curr.add(left);
                    curr.add(right);
                    res.add(curr);
                }
                left = right = i;
            }
        }

        if (right - left >= 2) {
            List<Integer> curr = new ArrayList();
            curr.add(left);
            curr.add(right);
            res.add(curr);
        }

        return res;
    }

    @Test
    public void test1() {
        List<List<Integer>> res = largeGroupPositions("abcdddeeeeaabbbcd");
    }
}