import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingPuzzleTest {
  @ParameterizedTest
  @MethodSource("cases")
  void slidingPuzzle(int[][] board, int output) {
    SlidingPuzzle solution = new SlidingPuzzle();
    assertEquals(output, solution.slidingPuzzle(board));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        new int[]{1, 2, 3},
        new int[]{4, 0, 5}
      }, 1),
      Arguments.of(new int[][]{
        new int[]{1, 2, 3},
        new int[]{5, 4, 0}
      }, -1),
      Arguments.of(new int[][]{
        new int[]{4, 1, 2},
        new int[]{5, 0, 3}
      }, 5),
      Arguments.of(new int[][]{
        new int[]{3, 2, 4},
        new int[]{1, 5, 0}
      }, 14)
    );
  }
}
