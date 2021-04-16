import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySignTest {
  @ParameterizedTest
  @MethodSource("cases")
  void arraySign(int[] nums, int output) {
    ArraySign solution = new ArraySign();
    assertEquals(output, solution.arraySign(nums));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{-1, -2, -3, -4, 3, 2, 1}, 1),
      Arguments.of(new int[]{1, 5, 0, 2, -3}, 0),
      Arguments.of(new int[]{-1, 1, -1, 1, -1}, -1)
    );
  }
}
