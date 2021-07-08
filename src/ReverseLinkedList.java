import ds.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
  private ListNode reverse(ListNode current, ListNode previous) {
    if (current != null) {
      current.next = previous;
      current = reverse(current.next, current);
    }

    return current;
  }

  public ListNode reverseList(ListNode head) {
    return reverse(null, head);
  }
}
