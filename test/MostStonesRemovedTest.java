import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostStonesRemovedTest {
  @ParameterizedTest
  @MethodSource("cases")
  void removeStones(int[][] stones, int output) {
    MostStonesRemoved solution = new MostStonesRemoved();
    assertEquals(output, solution.removeStones(stones));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        {0, 0},
        {0, 1},
        {1, 0},
        {1, 2},
        {2, 1},
        {2, 2}
      }, 5),
      Arguments.of(new int[][]{
        {0, 0},
        {0, 2},
        {1, 1},
        {2, 0},
        {2, 2}
      }, 3),
      Arguments.of(new int[][]{
        {0, 0}
      }, 0),
      Arguments.of(new int[][]{
        {0, 1},
        {0, 2},
        {4, 3},
        {2, 4},
        {0, 3},
        {1, 1}
      }, 4),
      Arguments.of(new int[][] {
        {3,3},
        {4,4},
        {1,4},
        {1,5},
        {2,3},
        {4,3},
        {2,4}
      }, 6),
      Arguments.of(new int[][] {
        {1,2},{1,3},{3,3},{3,1},{2,1},{1,0}
      }, 5)
    );
  }
}
