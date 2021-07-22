import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfClosedIslandsTest {
  @ParameterizedTest
  @MethodSource("cases")
  void closedIsland(int[][] grid, int output) {
    NumberOfClosedIslands solution = new NumberOfClosedIslands();
    assertEquals(output, solution.closedIsland(grid));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        {1, 1, 1, 1, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 1, 1, 0},
        {1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0}
      }, 2),
      Arguments.of(new int[][]{
        {0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 1, 1, 0}
      }, 1),
      Arguments.of(new int[][] {
        {1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1},
        {1,0,1,1,1,0,1},
        {1,0,1,0,1,0,1},
        {1,0,1,1,1,0,1},
        {1,0,0,0,0,0,1},
        {1,1,1,1,1,1,1}
      }, 2),
      Arguments.of(new int[][] {
        {0,0,1,1,0,1,0,0,1,0},
        {1,1,0,1,1,0,1,1,1,0},
        {1,0,1,1,1,0,0,1,1,0},
        {0,1,1,0,0,0,0,1,0,1},
        {0,0,0,0,0,0,1,1,1,0},
        {0,1,0,1,0,1,0,1,1,1},
        {1,0,1,0,1,1,0,0,0,1},
        {1,1,1,1,1,1,0,0,0,0},
        {1,1,1,0,0,1,0,1,0,1},
        {1,1,1,0,1,1,0,1,1,0}
      }, 5)
    );
  }
}


