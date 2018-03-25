package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution551 {
    public boolean checkRecord(String s) {
        if (s == null || s.isEmpty())
            return true;

        int a = 0;
        int l1 = 0;
        int l2 = 0;
        for(char c :s.toCharArray()) {
            if (c == 'P') {
                l1 = 0;
                l2 = 0;
                continue;
            }

            if (c == 'A') {a++;
                l1 = 0;
                l2 = 0;
                continue;
            }

            if (c== 'L') {
                if (l1 == 0) {
                    l1++;
                }
                else {
                    l2++;
                    if (l2 > 1)
                        return false;
                }
            }
        }
        return (a < 2);
    }

    @Test
    public void test1() {
        assertEquals(true, checkRecord("PPALLP"));
        assertEquals(false, checkRecord("PPALLL"));
    }
}
