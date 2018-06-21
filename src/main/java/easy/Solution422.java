package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Solution422 {
  public boolean validWordSquare(List<String> words) {
    if (words == null || words.size() == 0) {
      return true;
    }

    int n = words.size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        if (j >= n
            || words.get(j).length() <= i
            || words.get(j).charAt(i) != words.get(i).charAt(j)) return false;
      }
    }
    return true;
  }

  @Test
  public void test() {
    List<String> list = new ArrayList<>();
    list.add("abcd");
    list.add("bnrt");
    list.add("crmy");
    list.add("dtye");
    assertTrue(validWordSquare(list));
  }
}
