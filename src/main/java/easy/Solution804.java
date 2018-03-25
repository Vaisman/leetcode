package easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Solution804 {
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> pocket = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray()) {
                code.append(morse[c - 'a']);
            }
            pocket.add(code.toString());
        }
        return pocket.size();
    }

    @Test
    public void test1() {
        assertEquals(2, uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
