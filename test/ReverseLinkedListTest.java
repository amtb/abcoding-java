import ds.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseLinkedListTest {
  @ParameterizedTest
  @MethodSource("cases")
  void reverseList(int[] nums, int[] expected) {
    ReverseLinkedList solution = new ReverseLinkedList();
    int[] reversed = ListNode.toArray(solution.reverseList(ListNode.from(nums)));
    assertArrayEquals(expected, reversed);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}),
      Arguments.of(new int[]{}, new int[] {}),
      Arguments.of(new int[]{1}, new int[] {1})
    );
  }
}
