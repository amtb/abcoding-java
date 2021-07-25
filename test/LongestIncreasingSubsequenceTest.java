import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTest {
  @ParameterizedTest
  @MethodSource("cases")
  void arraySign(int[] nums, int output) {
    LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
    assertEquals(output, solution.lengthOfLIS(nums));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
      Arguments.of(new int[]{0,1,0,3,2,3}, 4),
      Arguments.of(new int[]{7, 7, 7, 7, 7}, 1)
    );
  }
}
