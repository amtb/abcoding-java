import java.util.PriorityQueue;
import java.util.Queue;

public class ThridMax {

  static final int MAX = 3;
  Queue<Integer> pq = new PriorityQueue<>();

  private void insert(int num) {
    if (!pq.contains(num)) pq.offer(num);
    if (pq.size() > MAX) pq.poll();
  }

  public int thirdMax(int[] nums) {
    for (int num : nums) {
      insert(num);
    }

    if (pq.size() == MAX) {
      return pq.peek();
    }
    while (pq.size() != 1) pq.poll();
    return pq.poll();
  }
}
