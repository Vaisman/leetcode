import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

class MyCalendarTwo {

    private TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (end < 0 || start < 0) return false;
        if (end < start) return false;

        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

public class Solution27 {
    @Test
    public void test() {
        MyCalendarTwo calendar = new MyCalendarTwo();
        assertFalse(calendar.book(-110, 20));
        assertTrue(calendar.book(10, 20));
        assertTrue(calendar.book(50, 60));
        assertTrue(calendar.book(10, 40));
        assertFalse(calendar.book(5, 15));
        assertTrue(calendar.book(5, 10));
        assertTrue(calendar.book(25, 55));
    }
}
