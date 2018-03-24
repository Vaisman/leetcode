package zero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution70 {
  class WordDictionary {

    class TrieNode {
      private TrieNode[] links;
      private final int R = 26;
      private boolean isEnd;

      public TrieNode() {
        links = new TrieNode[R];
      }

      public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
      }

      public TrieNode get(char ch) {
        return links[ch - 'a'];
      }

      public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
      }

      public void setEnd() {
        isEnd = true;
      }

      public boolean isEnd() {
        return isEnd;
      }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
      root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (!node.containsKey(c)) {
          node.put(c, new TrieNode());
        }
        node = node.get(c);
      }
      node.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
      return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] array, int k, TrieNode node) {
      if (k == array.length) return node.isEnd();

      if (array[k] != '.') {
        return node.get(array[k]) != null && match(array, k + 1, node.get(array[k]));
      } else {
        for (char i = 'a'; i < 'a' + 26; i++) {
          if (node.get(i) != null) {
            if (match(array, k + 1, node.get(i))) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }

  @Test
  public void test() {
    WordDictionary dict = new WordDictionary();
    dict.addWord("bad");
    dict.addWord("dad");
    dict.addWord("mad");
    assertEquals(dict.search("pad"), false);
    assertEquals(dict.search("bad"), true);
    assertEquals(dict.search(".ad"), true);
    assertEquals(dict.search("b.."), true);
  }
}
