package zero;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class Solution4 {

  public List<String> letterCasePermutation(String S) {
    List<StringBuilder> res = new ArrayList();
    res.add(new StringBuilder());

    for (char c : S.toCharArray()) {
      int n = res.size();
      if (Character.isLetter(c)) {
        for (int i = 0; i < n; ++i) {
          res.add(new StringBuilder(res.get(i)));
          res.get(i).append(Character.toLowerCase(c));
          res.get(n + i).append(Character.toUpperCase(c));
        }
      } else {
        for (int i = 0; i < n; ++i) res.get(i).append(c);
      }
    }

    List<String> finalans = new ArrayList();
    for (StringBuilder sb : res) finalans.add(sb.toString());
    return finalans;
  }

  @Test
  public void test() {
    List<String> categories = asList("a1b2", "A1b2", "a1B2", "A1B2");
    assertTrue(categories.equals(letterCasePermutation("a1b2")));
  }
}
