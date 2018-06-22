package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class StringIterator {
  private String s;
  private int index = 0;
  private int num = 0;
  private char ch = ' ';

  StringIterator(String s) {
    this.s = s;
    num = 0;
  }

  public char next() {
    if (!hasNext()) return ' ';

    if (num == 0) {
      // get ch
      ch = s.charAt(index);

      // get number
      index++;
      while (index < s.length() && Character.isDigit(s.charAt(index))) {
        num = num * 10 + s.charAt(index++) - '0';
      }
    }
    num--;

    return ch;
  }

  boolean hasNext() {
    return index != s.length() || num != 0;
  }
}

public class Solution604 {
  @Test
  public void test() {
    StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
    assertEquals(iterator.next(), 'L'); // return 'L'
    assertEquals(iterator.next(), 'e'); // return 'e'
    assertEquals(iterator.next(), 'e'); // return 'e'
    assertEquals(iterator.next(), 't'); // return 't'
    assertEquals(iterator.next(), 'C'); // return 'C'
    assertEquals(iterator.next(), 'o'); // return 'o'
    assertEquals(iterator.next(), 'd'); // return 'd'
    assertEquals(iterator.hasNext(), true); // return true
    assertEquals(iterator.next(), 'e'); // return 'e'
    assertEquals(iterator.hasNext(), false); // return false
    assertEquals(iterator.next(), ' '); // return ' '
  }
}
