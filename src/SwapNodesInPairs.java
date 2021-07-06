import ds.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
  private ListNode swap(ListNode node) {
    if (node != null && node.next != null) {
      ListNode prev = node;
      ListNode next = node.next;

      prev.next = swap(next.next);
      next.next = prev;

      node = next;
    }

    return node;
  }

  public ListNode swapPairs(ListNode head) {
    return swap(head);
  }
}
