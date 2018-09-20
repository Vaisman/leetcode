package easy;

import java.util.Stack;

public class Solution844 {
  private String getString(String str) {
    int n = str.length(), count = 0;
    String result = "";
    for (int i = n - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (ch == '#') count++;
      else {
        if (count > 0) count--;
        else {
          result += ch;
        }
      }
    }
    return result;
  }

  public boolean backspaceCompare(String S, String T) {
    return getString(S).equals(getString(T));
  }

  public boolean backspaceCompare1(String S, String T) {
    return build(S).equals(build(T));
  }

  public String build(String S) {
    Stack<Character> ans = new Stack();
    for (char c : S.toCharArray()) {
      if (c != '#') ans.push(c);
      else if (!ans.empty()) ans.pop();
    }
    return String.valueOf(ans);
  }
}
