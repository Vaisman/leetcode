import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution72 {
    public String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }

        return res.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals(convertToTitle(1), "A");
        assertEquals(convertToTitle(2), "B");
        assertEquals(convertToTitle(3), "C");
        assertEquals(convertToTitle(26), "Z");
        assertEquals(convertToTitle(27), "AA");
        assertEquals(convertToTitle(28), "AB");
    }
}
