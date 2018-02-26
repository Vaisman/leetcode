import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2 {

    public int longestPalindrome(String s) {

        int [] mem = new int[256];
        for(char c : s.toCharArray()) {
            mem[c]++;
        }

        int evenCounter = 0;
        int oddCounter = 0;
        for(int i: mem) {

            if ((i % 2) == 0) {
                evenCounter += i;
            }
            else if ((i % 2) > 0) {
                evenCounter += (i - 1);
                oddCounter = 1;
            }
            else
                oddCounter = 1;

        }
        return evenCounter + oddCounter;
    }

    public int longestPalindromeEff(String s) {
        int[] map = new int[128];
        int res = 0;
        for(char c : s.toCharArray()){
            if(map[c]++ % 2 == 1)
                res += 2;
        }
        return s.length() > res ? 1 + res : res;
    }

    @Test
    public void test1() {
        assertEquals(0, longestPalindrome(""));
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(3, longestPalindrome("ccc"));
    }

    @Test
    public void test2() {
        assertEquals(0, longestPalindromeEff(""));
        assertEquals(7, longestPalindromeEff("abccccdd"));
        assertEquals(3, longestPalindromeEff("ccc"));
    }
}
