import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsIITest {
  @ParameterizedTest
  @MethodSource("cases")
  void uniquePathsWithObstacles(int[][] grid, int expected) {
    UniquePathsII solution = new UniquePathsII();
    assertEquals(expected, solution.uniquePathsWithObstacles(grid));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        new int[] {0,0,0},
        new int[] {0,1,0},
        new int[] {0,0,0},
      }, 2),
      Arguments.of(new int[][]{
        new int[] {0, 1},
        new int[] {0, 0}
      }, 1)
    );
  }
}
