import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestTest {

  @Test
  void kthLargest() {
    KthLargest solution = new KthLargest(3, new int[] {4, 5, 8, 2});
    assertEquals(4, solution.add(3));
    assertEquals(5, solution.add(5));
    assertEquals(5, solution.add(10));
    assertEquals(8, solution.add(9));
    assertEquals(8, solution.add(4));
  }
}
