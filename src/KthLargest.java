import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
class KthLargest {
  final int k;
  final PriorityQueue<Integer> pq;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    pq = new PriorityQueue<>();

    for (int num : nums) insert(num);
  }

  private void insert(int val) {
    if (pq.size() < k) {
      pq.offer(val);
    } else {
      int kth = pq.peek();
      if (val > kth) {
        pq.offer(val);
        pq.poll();
      }
    }
  }

  public int add(int val) {
    insert(val);
    return pq.peek();
  }
}
