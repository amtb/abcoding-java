import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGoodRectanglesTest {
  @ParameterizedTest
  @MethodSource("cases")
  void countGoodRectangles(int[][] rectangles, int output) {
    CountGoodRectangles solution = new CountGoodRectangles();
    assertEquals(output, solution.countGoodRectangles(rectangles));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(new int[][]{
        {5, 8},
        {3, 9},
        {5, 12},
        {16, 5}
      }, 3),
      Arguments.of(new int[][]{
        {2, 3},
        {3, 7},
        {4, 3},
        {3, 7}
      }, 3),
      Arguments.of(new int[][]{
        {3, 1}
      }, 1)
    );
  }
}
