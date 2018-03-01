import org.junit.Test;

import java.util.TreeMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

class MyCalendar {

    private TreeMap<Integer, Integer> mem = new TreeMap<>();

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        if (end < 0 || start < 0) return false;
        if (end < start) return false;

        Integer prev = mem.lowerKey(start);
        Integer next = mem.ceilingKey(start);

        if ((prev == null || mem.get(prev) <= start) && (next == null || end <= next)) {
            mem.put(start, end);
            return true;
        }
        return false;
    }
}

public class Solution25 {
    @Test
    public void test() {
        MyCalendar calendar = new MyCalendar();
        assertTrue(calendar.book(10, 20));
        assertFalse(calendar.book(-110, 20));
        assertFalse(calendar.book(20, 10));
        assertTrue(calendar.book(20, 30));
        assertFalse(calendar.book(10, 40));
        assertFalse(calendar.book(5, 15));
        assertFalse(calendar.book(15, 50));
    }
}
