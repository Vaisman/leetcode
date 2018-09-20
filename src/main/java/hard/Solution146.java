package hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {
  ListNode head;
  ListNode tail;
  int capacity;

  Map<Integer, ListNode> map;

  public Solution146(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  public int get(int key) {
    ListNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    remove(node);
    insert(node);
    return node.val;
  }

  public void put(int key, int value) {
    ListNode node = map.get(key);
    if (node == null) {
      if (map.size() == capacity) {
        map.remove(tail.key);
        remove(tail);
      }
      node = new ListNode(key, value);
      insert(node);
      map.put(key, node);
    } else {
      remove(node);
      insert(node);
      node.val = value;
    }
  }

 // ----------------------------------
  private void remove(ListNode node) {
    if (node.prev == null) {
      head = head.next;
    } else {
      node.prev.next = node.next;
    }

    if (node.next == null) {
      tail = tail.prev;
    } else {
      node.next.prev = node.prev;
    }

    node.prev = null;
    node.next = null;
  }

  private void insert(ListNode node) {
    if (head == null && tail == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
}

class ListNode {
  int val;
  int key;
  ListNode prev;
  ListNode next;

  public ListNode(int key, int val) {
    this.val = val;
    this.key = key;
  }
}
