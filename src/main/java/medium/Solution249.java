package medium;

import java.util.*;

public class Solution249 {

    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> m = new HashMap<>();

        for (String s : strings) {
            StringBuilder b = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = s.charAt(i) - s.charAt(i - 1);
                diff = diff >= 0 ? diff : 26 + diff;
                b.append(diff);
            }
            String key = b.toString();
            m.putIfAbsent(key, new LinkedList<>());
            m.get(key).add(s);
        }
        return new ArrayList<>(m.values());
    }

}
