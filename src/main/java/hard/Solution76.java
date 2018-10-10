package hard;

public class Solution76 {
  public String minWindow(String s, String t) {
    int[] hash = new int[128];

    for (char ch : t.toCharArray()) {
      hash[ch]++;
    }

    int num = 0;

    for (int h : hash) {
      if (h != 0) {
        num++;
      }
    }

    int min = Integer.MAX_VALUE;
    int from = 0, to = -1;

    for (int start = 0, end = 0; end < s.length(); end++) {
      hash[s.charAt(end)]--;

      if (hash[s.charAt(end)] == 0) {
        num--;
      }

      if (num == 0) {
        // we have a valid substring. moving start to minimize it
        for (; start <= end; start++) {
          if (end - start + 1 < min) {
            from = start;
            to = end;
            min = end - start + 1;
          }

          hash[s.charAt(start)]++;

          if (hash[s.charAt(start)] > 0) {
            // we lose the valid string
            num++; // we have one outstanding char
            start++; // BUG
            break;
          }
        }
      }
    }

    return s.substring(from, to + 1);
  }
}
