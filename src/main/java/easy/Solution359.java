package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution359 {
  private Map<String, Integer> ok = new HashMap<>();

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (timestamp < ok.getOrDefault(message, 0)) return false;
    ok.put(message, timestamp + 10);
    return true;
  }
}
