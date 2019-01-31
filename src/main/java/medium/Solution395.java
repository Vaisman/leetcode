package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public int helper(char[] ch, int l, int r, int k) {
        if (r - l < k)
            return 0;

        int[] map = new int[26];
        for (int i = l; i < r; i++)
            map[ch[i] - 'a']++;

        for (int i = l; i < r; i++) {
            if (map[ch[i] - 'a'] < k) {
                return Math.max(helper(ch, l, i, k), helper(ch, i+1, r, k));
            }
        }
        return r - l;
    }

    @Test
    public void longestSubstringTest() {
        assertEquals(longestSubstring("ababbc", 2), 5);
    }
}
