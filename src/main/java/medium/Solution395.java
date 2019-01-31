package medium;

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
                int j = i + 1;
                while (j < r && map[ch[j] - 'a'] < k)
                    j++;
                return Math.max(helper(ch, l, i, k), helper(ch, j, r, k));
            }
        }
        return r - l;
    }
}
