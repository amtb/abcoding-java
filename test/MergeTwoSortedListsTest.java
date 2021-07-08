import ds.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTwoSortedListsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void mergeTwoSortedLists(int[] l1, int[] l2, int[] expected) {
    MergeTwoSortedLists solution = new MergeTwoSortedLists();
    assertArrayEquals(expected, solution.mergeTwoLists(ListNode.from(l1), ListNode.from(l2)).toArray());
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{1,2,4},new int[]{1,3,4}, new int[]{1,1,2,3,4,4}),
      Arguments.of(new int[]{}, new int[]{}, new int[]{}),
      Arguments.of(new int[]{}, new int[]{0}, new int[]{0}),
      Arguments.of(new int[]{5}, new int[]{1,2,4}, new int[]{1,2,4,5})
    );
  }
}
