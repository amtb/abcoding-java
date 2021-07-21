import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {
  @ParameterizedTest
  @MethodSource("cases")
  void minDifference(int[] nums, int output) {
    MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves solution = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
    assertEquals(output, solution.minDifference(nums));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[]{5, 3, 2, 4}, 0),
      Arguments.of(new int[]{1, 5, 0,10,14}, 1),
      Arguments.of(new int[]{6,6,0,1,1,4,6},2),
      Arguments.of(new int[] {1,5,6,14,15}, 1)
    );
  }
}
