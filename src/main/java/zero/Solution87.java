package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution87 {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            res.append(sum % 2);
            sum = sum / 2;
        }
        if (sum != 0)
            res.append(sum);
        return res.reverse().toString();
    }
    @Test
    public void test() {
        assertEquals(addBinary("0","0"), "0");
    }
}
