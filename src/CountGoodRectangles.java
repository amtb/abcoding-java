import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
public class CountGoodRectangles {
  public int countGoodRectangles(int[][] rectangles) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((l, r) -> r - l);

    for (int[] rectangle : rectangles) {
      pq.offer(Math.min(rectangle[0], rectangle[1]));
    }

    int max = pq.peek();
    int count = 0;
    while (!pq.isEmpty() && pq.poll() == max) count += 1;

    return count;
  }

  public int countGoodRectanglesAgain(int[][] rectangles) {
    int max = 0;
    int count = 0;
    for (int[] rectangle : rectangles) {
      int side = Math.min(rectangle[0], rectangle[1]);
      if (side > max) {
        max = side;
        count = 1;
      } else {
        count += max == side ? 1 : 0;
      }
    }

    return count;
  }
}
