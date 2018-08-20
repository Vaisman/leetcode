package easy;

import common.ListNode;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class Solution20 {
  public boolean isValid(String s) {

    if (s == null || s.length() == 0) return true;

    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch == '{' || ch == '[' || ch == '(') stack.push(ch);
      else {
        if (stack.isEmpty()) return false;

        char left = stack.pop();

        if (left == '{') {
          if (ch != '}')
              return false;
        }
          if (left == '[') {
              if (ch != ']')
                  return false;
          }
          if (left == '(') {
              if (ch != ']')
                  return false;
          }
      }
    }
    return true;
  }

    public ListNode deleteDuplicates(ListNode head) {
        if ((head == null) || (head.next == null)) return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null && curr.next != null){
            if (prev.val == curr.val) {
                prev.next = curr.next;
                curr = curr.next.next;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }

        return head;
    }

    @Test
    public void test() {
      ListNode n1 = new ListNode(1);
      n1.next = new ListNode(3);
      n1.next.next = new ListNode(3);

        ListNode n = deleteDuplicates(n1);

        assertEquals(isValid("{}"), true);
    }
}