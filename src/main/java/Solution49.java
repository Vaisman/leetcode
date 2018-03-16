import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution49 {

  public int romanToInt(String s) {
    Map<Character, Integer> T = new HashMap();
    T.put('I', 1);
    T.put('V', 5);
    T.put('X', 10);
    T.put('L', 50);
    T.put('C', 100);
    T.put('D', 500);
    T.put('M', 1000);

    int res = T.get(s.charAt(s.length()-1));
    for(int i = s.length() - 2 ; i >= 0 ; i--) {
      if (T.get(s.charAt(i)) < T.get(s.charAt(i+1)))
        res -= T.get(s.charAt(i));
      else
        res += T.get(s.charAt(i));
    }

    return res;
  }

  @Test
  public void test() {
    assertEquals(1, romanToInt("I"));
    assertEquals(8, romanToInt("VIII"));
  }
}
