import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertIntervalTest {
  @ParameterizedTest
  @MethodSource("cases")
  void insert(int[][] intervals, int[] newInterval, int[][] expected) {
    InsertInterval solution = new InsertInterval();
    assertArrayEquals(expected, solution.insert(intervals, newInterval));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
      Arguments.of(
        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
        new int[]{4, 8},
        new int[][]{{1, 2}, {3, 10}, {12, 16}}
      ),
      Arguments.of(new int[][]{}, new int[]{5, 7}, new int[][]{{5, 7}}),
      Arguments.of(new int[][]{{1, 5}}, new int[]{2, 3}, new int[][]{{1, 5}}),
      Arguments.of(new int[][]{{1, 5}}, new int[]{2, 7}, new int[][]{{1, 7}}),
      Arguments.of(new int[][]{{1, 5}}, new int[]{6, 8}, new int[][]{{1, 5}, {6, 8}}),
      Arguments.of(new int[][]{{1, 5}}, new int[]{0, 3}, new int[][]{{0, 5}}),
      Arguments.of(new int[][]{{1, 5}}, new int[]{0, 0}, new int[][]{{0, 0}, {1, 5}})
    );
  }
}
