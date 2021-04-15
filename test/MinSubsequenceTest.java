import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinSubsequenceTest {
  @ParameterizedTest
  @MethodSource("cases")
  void minSubsequence(int[] nums, Integer[] output) {
    MinSubsequence solution = new MinSubsequence();
    assertArrayEquals(output, solution.minSubsequence(nums).toArray());
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{4, 3, 10, 9, 8}, new Integer[]{10, 9}),
      Arguments.of(new int[]{4, 4, 7, 6, 7}, new Integer[]{7, 7, 6}),
      Arguments.of(new int[]{6}, new Integer[]{6})
    );
  }
}
