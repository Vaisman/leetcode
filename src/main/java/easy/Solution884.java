package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Solution884 {
  public String[] uncommonFromSentences(String A, String B) {
    List<String> res = new ArrayList<>();
    Map<String, Integer> hash = new HashMap<>();

    String[] splitA = A.split(" ");
    String[] splitB = B.split(" ");

    for (String s : splitA) {
      hash.put(s, hash.getOrDefault(s, 0) + 1);
    }
    for (String s : splitB) {
      hash.put(s, hash.getOrDefault(s, 0) + 1);
    }

    for (Map.Entry<String, Integer> e : hash.entrySet()) {
      if (e.getValue() == 1) res.add(e.getKey());
    }

    String[] out = new String[res.size()];
    res.toArray(out);
    return out;
  }

  @Test
  public void test() {
    assertArrayEquals(
        new String[] {"sweet", "sour"},
        uncommonFromSentences("this apple is sweet", "this apple is sour"));
  }
}
