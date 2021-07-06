package ds;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode from(int[] array) {
    return from(array, 0);
  }

  static ListNode from(int[] array, int index) {
    if (index < array.length) {
      ListNode node = new ListNode(array[index]);
      node.next = from(array, index + 1);
      return node;
    }

    return null;
  }

  public static int[] toArray(ListNode head) {
    List<Integer> list = new LinkedList<>();
    for (ListNode node = head; node != null; node = node.next) {
      list.add(node.val);
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
