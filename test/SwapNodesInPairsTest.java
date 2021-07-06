import ds.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SwapNodesInPairsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void swapPairs(int[] nums, int[] expected) {
    SwapNodesInPairs solution = new SwapNodesInPairs();
    int[] swapped = ListNode.toArray(solution.swapPairs(ListNode.from(nums)));
    assertArrayEquals(expected, swapped);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2,1,4,3}),
      Arguments.of(new int[]{}, new int[] {}),
      Arguments.of(new int[]{1}, new int[] {1})
    );
  }
}
