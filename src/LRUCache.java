import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
  static class Node {
    int key;
    int value;
    Node previous;
    Node next;

    Node() {
    }

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  static class Deque {
    Node head;
    Node tail;

    Deque() {
      head = new Node();
      tail = new Node();

      head.next = tail;
      tail.previous = head;
    }

    public void moveUpfront(Node n) {
      Node front = head.next;

      if (front == n) return;

      Node previous = n.previous;
      Node next = n.next;

      if (previous != null) previous.next = next;
      if (next != null) next.previous = previous;

      n.next = front;
      n.previous = head;

      front.previous = n;

      head.next = n;
    }

    // Removes the last item and returns the key previously associated if any
    public Integer removeLast() {
      if (tail.previous != head) {
        Node previous = tail.previous;
        tail.previous = previous.previous;
        previous.previous.next = tail;

        return previous.key;
      }

      return null;
    }
  }

  private final int capacity;
  private Deque queue;
  private Map<Integer, Node> items;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    items = new HashMap<>();
    queue = new Deque();
  }

  public int get(int key) {
    Node node = items.get(key);
    if (node != null) {
      queue.moveUpfront(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (items.size() >= capacity && !items.containsKey(key)) {
      Integer last = queue.removeLast();
      if (last != null) items.remove(last);
    }

    Node node = items.getOrDefault(key, new Node(key, value));
    node.value = value;
    queue.moveUpfront(node);

    items.put(key, node);
  }
}

