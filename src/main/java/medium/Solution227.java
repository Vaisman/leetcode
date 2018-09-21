package medium;

import java.util.Stack;

public class Solution227 {
  public int calculate(String s) {
    int len;
    if (s == null || (len = s.length()) == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';
    for (int i = 0; i < len; i++) {
      if (Character.isDigit(s.charAt(i))) {
        num = num * 10 + s.charAt(i) - '0';
      }
      if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
        if (sign == '-') {
          stack.push(-num);
        }
        if (sign == '+') {
          stack.push(num);
        }
        if (sign == '*') {
          stack.push(stack.pop() * num);
        }
        if (sign == '/') {
          stack.push(stack.pop() / num);
        }
        sign = s.charAt(i);
        num = 0;
      }
    }

    int re = 0;
    for (int i : stack) {
      re += i;
    }
    return re;
  }

  //////////////////////////////////

  public int calculate1(String s) {
    int num = 0, temp = 0, res = 0;
    char sign = '+';
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') {
        temp = temp * 10 + (c - '0');
      } else if (c != ' ') {
        num = calc1(num, temp, sign);
        if (c == '+' || c == '-') {
          res += num;
          num = 0;
        }
        temp = 0;
        sign = c;
      }
    }
    return res + calc1(num, temp, sign);
  }

  private int calc1(int a, int b, char s) {
    if (s == '+') return a + b;
    if (s == '-') return a - b;
    if (s == '*') return a * b;
    return a / b;
  }
}
