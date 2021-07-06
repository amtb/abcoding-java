import ds.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ListNodeTest {
  @ParameterizedTest
  @MethodSource("cases")
  void snipSnap(int[] nums) {
    ListNode list = ListNode.from(nums);
    assertArrayEquals(nums, ListNode.toArray(list));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{20, 90, 40, 90}),
      Arguments.of(new int[]{30, 30, 10, 10}),
      Arguments.of(new int[]{999, 999, 999})
    );
  }
}
